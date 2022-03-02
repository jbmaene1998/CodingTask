package com.CodingTask.CodingTask.dto;

import lombok.Data;

import java.util.List;

@Data
public class outputResponseDto {
    private long totalFirehosesLength;
    private List<hydrantsToFireResponseDto> hydrants;
}
