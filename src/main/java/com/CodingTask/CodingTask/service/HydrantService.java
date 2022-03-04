package com.CodingTask.CodingTask.service;

import com.CodingTask.CodingTask.bmc.HydrantClient;
import com.CodingTask.CodingTask.dto.InputRequestDto;
import com.CodingTask.CodingTask.dto.OutputResponseDto;
import com.CodingTask.CodingTask.helper.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HydrantService {

    @Autowired
    private HydrantClient hydrantClient;

    @Value("${hydrant.select}")
    private String PARAM_SELECT;
    @Value("${hydrant.where}")
    private String PARAM_WHERE;
    @Value("${hydrant.order}")
    private String PARAM_ORDER;
    @Value("${hydrant.limit}")
    private String PARAM_LIMIT;


    public OutputResponseDto getHydrants(InputRequestDto dto){
        return Mapper.mapToOutputResponseDto(
                hydrantClient.getHydrants(
                String.format(PARAM_SELECT, dto.getFireLatitude(), dto.getFireLongitude()),
                String.format(PARAM_WHERE, dto.getFireLongitude(), dto.getFireLatitude()),
                PARAM_ORDER,
                String.format(PARAM_LIMIT, dto.getNumberOfFiretrucks())));
    }
}
