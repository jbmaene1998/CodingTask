package com.CodingTask.CodingTask.helper;

import org.springframework.stereotype.Component;

@Component("calculator")
public class calculatorImpl implements com.CodingTask.CodingTask.Interface.calculator {
    public Double getDistanceFromLatLonInKm(Double lat1, Double lon1, Double lat2, Double lon2) {
        var radiusEarth = 6371;
        var dLat = deg2Rad(lat1 - lat2);
        var dLon = deg2Rad(lon1 - lon2);
        var a = Math.sin(dLat/2) * Math.sin(dLat) +
                Math.cos(deg2Rad(lat1)) * Math.cos(deg2Rad(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return radiusEarth * c;
    }

    public Double deg2Rad(Double degree){
        return degree * (Math.PI/180);
    }
}
