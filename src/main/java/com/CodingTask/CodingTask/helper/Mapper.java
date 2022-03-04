package com.CodingTask.CodingTask.helper;

import com.CodingTask.CodingTask.dto.HydrantDto;
import com.CodingTask.CodingTask.dto.OutputResponseDto;

import java.util.List;

public class Mapper {
    public static OutputResponseDto mapToOutputResponseDto(List<HydrantDto> hydrants){
        return OutputResponseDto.builder()
                .hydrants(hydrants)
                .totalFirehosesLength(hydrants
                        .stream()
                        .mapToLong(HydrantDto::getMeterToFire)
                        .sum())
                .build();
    }
}
