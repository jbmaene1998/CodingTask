package com.CodingTask.CodingTask.Interface;

import com.CodingTask.CodingTask.dto.outputResponseDto;

import java.util.List;

public interface socrataService {
    Number connect();
    StringBuffer get();
    void convertJsonDataToHydrants();
    outputResponseDto getResults(double longitude, double latitude, int numberOfTrucks);

}
