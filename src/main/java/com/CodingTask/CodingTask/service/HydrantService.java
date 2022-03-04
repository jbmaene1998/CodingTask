package com.CodingTask.CodingTask.service;

import com.CodingTask.CodingTask.dto.inputRequestDto;
import com.CodingTask.CodingTask.dto.outputResponseDto;
import com.CodingTask.CodingTask.helper.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HydrantService {

    @Autowired
    private Mapper mapper;
    @Autowired
    private com.CodingTask.CodingTask.bmc.hydrantClient hydrantClient;


    public outputResponseDto getHydrants(inputRequestDto dto){
        return mapper.mapToOutputResponseDto(
                hydrantClient.getHydrants(
                String.format("unitId, ROUND(DISTANCE_IN_METERS(the_geom, 'POINT(%s %s)'), 0) AS meterToFire", dto.getFireLatitude(), dto.getFireLongitude()),
                String.format("within_circle(the_geom,%s,%s, 25000)", dto.getFireLongitude(), dto.getFireLatitude()),
                "meterToFire",
                String.format("%s", dto.getNumberOfFiretrucks())));
    }
}
