package com.CodingTask.CodingTask.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@Getter
@Setter
public class inputRequestDto {
    @Range(from = 40, to = 41)
    private double fireLongitude;
    @Range(from = -75, to = -73)
    private double fireLatitude;

    @Max(value = 2,message="Max is 2")
    @Min(value = 1, message = "min is 1")
    private int numberOfFiretrucks;

}
