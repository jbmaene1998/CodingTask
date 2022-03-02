package com.CodingTask.CodingTask.helper;

import com.CodingTask.CodingTask.dto.hydrantsToFireResponseDto;
import com.CodingTask.CodingTask.dto.outputResponseDto;
import com.CodingTask.CodingTask.entity.hydrant;
import com.CodingTask.CodingTask.entity.hydrantToFire;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("mapper")
public class mapper {
    //Json mappers
    public hydrant mapToHydrant(String unitId, Double longitude, Double latitude){
        hydrant hydrant = new hydrant(unitId, longitude, latitude);
        return hydrant;
    }

    //Dto / Entity mappers
    public hydrantsToFireResponseDto hydrantsToFireEntityToDto(hydrantToFire htf){
        hydrantsToFireResponseDto hydrantsToFireResponseDto = new hydrantsToFireResponseDto();
        hydrantsToFireResponseDto.setKmToFire(htf.getKmToFire());
        hydrantsToFireResponseDto.setUnitId(htf.getUnitId());
        return hydrantsToFireResponseDto;
    }

    public outputResponseDto mapHydrantsToFireEntityToDtoAndTotalFirehosesLength(long totalFirehosesLength, List<hydrantsToFireResponseDto> hydrants){
        outputResponseDto dto = new outputResponseDto();
        dto.setTotalFirehosesLength(totalFirehosesLength);
        dto.setHydrants(hydrants);
        return dto;
    }
}
