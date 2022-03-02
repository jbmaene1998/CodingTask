package com.CodingTask.CodingTask.service;

import com.CodingTask.CodingTask.dto.hydrantsToFireResponseDto;
import com.CodingTask.CodingTask.dto.outputResponseDto;
import com.CodingTask.CodingTask.entity.hydrant;
import com.CodingTask.CodingTask.entity.hydrantToFire;
import com.CodingTask.CodingTask.helper.calculatorImpl;
import com.CodingTask.CodingTask.helper.mapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Component("socrataService")
public class socrataServiceImpl implements com.CodingTask.CodingTask.Interface.socrataService {

    private static HttpURLConnection connection;
    private BufferedReader reader;
    private String line;
    private StringBuffer responseContent = new StringBuffer();
    private List<hydrant> hydrants = new ArrayList<hydrant>();
    private List<hydrantToFire> hydrantsToFire = new ArrayList<hydrantToFire>();
    private com.CodingTask.CodingTask.helper.mapper mapper = new mapper();
    private com.CodingTask.CodingTask.helper.calculatorImpl calculator = new calculatorImpl();

    public socrataServiceImpl()
    {
        connect();
        get();
        convertJsonDataToHydrants();
    }

    public outputResponseDto getResults(double longitude, double latitude, int numberOfTrucks){
        for (int i = 0; i < hydrants.size(); i++) {
            var currentHydrant = hydrants.get(i);
            var kmToFire = Math.round (calculator.getDistanceFromLatLonInKm(
                    currentHydrant.getLatitude(),
                    currentHydrant.getLongitude(),
                    latitude,
                    longitude));
            var htf = new hydrantToFire(kmToFire, currentHydrant.getUnitId());
            hydrantsToFire.add(htf);
        }
        hydrantsToFire.sort((hydrantToFire htf1, hydrantToFire htf2)-> (int) (htf1.getKmToFire()-htf2.getKmToFire()));
        List<hydrantToFire> hydrants = new ArrayList<hydrantToFire>();
        for (int i = 0; i < numberOfTrucks; i++) {
            var selectedResult = hydrantsToFire.get(0);
            hydrants.add(selectedResult);
            hydrantsToFire.remove(0);
        }
        List<hydrantsToFireResponseDto> dtos = new ArrayList<hydrantsToFireResponseDto>();
        hydrants.forEach((hydrant) -> dtos.add(mapper.hydrantsToFireEntityToDto(hydrant)));

        var tempLength = 0;
        for (int i = 0; i < hydrants.size(); i++) {
            tempLength += hydrants.get(i).getKmToFire();
        }
        var result = mapper.mapHydrantsToFireEntityToDtoAndTotalFirehosesLength(tempLength, dtos);

        return result;
    }
    public void convertJsonDataToHydrants(){
        String str = responseContent.toString();
        try {
            JSONArray array = new JSONArray(str);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                var hydrant =  mapper.mapToHydrant(object.getString("unitid"),
                        Double.parseDouble(object.getString("longitude")),
                        Double.parseDouble(object.getString("latitude")));
                hydrants.add(hydrant);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Number connect(){
        try {
            URL url = new URL("https://data.cityofnewyork.us/resource/5bgh-vtsn.json");
            connection = (HttpURLConnection) url.openConnection();

            return connection.getResponseCode();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public StringBuffer get(){
        try {
            if (connection.getResponseCode() != 200){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }
        return responseContent;
    }

}
