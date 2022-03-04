package com.CodingTask.CodingTask.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class outputResponseDto {
    private long totalFirehosesLength;
    private List<hydrantDto> hydrants;
}
