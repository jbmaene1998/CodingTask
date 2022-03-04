package com.CodingTask.CodingTask.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.jetbrains.annotations.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Getter
@Setter
public class inputRequestDto {
    @NotNull
    @Max(value = 41,message="Value can't be higher then 41")
    @Min(value = 40, message = "Value can't be lower then 40")
    private double fireLongitude;

    @NotNull
    @Max(value = -73,message="Value can't be higher then -73")
    @Min(value = -75, message = "Value can't be lower then -75")
    private double fireLatitude;

    @NotNull
    @Max(value = 10,message="Value can't be higher then 10")
    @Min(value = 1, message = "Value can't be lower then 1")
    private int numberOfFiretrucks;

}
