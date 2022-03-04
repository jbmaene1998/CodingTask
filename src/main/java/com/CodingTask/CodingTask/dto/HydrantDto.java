package com.CodingTask.CodingTask.dto;

import lombok.*;

@Data
@Value
@Builder
@Getter
@Setter
public class HydrantDto {
    private String unitId;
    private int meterToFire;
}
