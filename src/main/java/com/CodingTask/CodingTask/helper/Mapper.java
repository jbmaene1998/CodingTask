package com.CodingTask.CodingTask.helper;

import com.CodingTask.CodingTask.dto.hydrantDto;
import com.CodingTask.CodingTask.dto.outputResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {
    public outputResponseDto mapToOutputResponseDto(List<hydrantDto> hydrants){
        return outputResponseDto.builder()
                .hydrants(hydrants)
                .totalFirehosesLength(hydrants
                        .stream()
                        .mapToLong(hydrantDto::getMeterToFire)
                        .sum())
                .build();
    }
}
