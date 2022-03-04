package com.CodingTask.CodingTask.dto;

import lombok.*;

@Data
@Value
@Builder
@Getter
@Setter
public class hydrantDto {
    private String unitId;
    private int meterToFire;
}
