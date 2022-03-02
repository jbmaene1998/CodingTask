package com.CodingTask.CodingTask.dto;

import lombok.Data;
import org.jetbrains.annotations.Range;

@Data
public class inputRequestDto {
    private double fireLongitude;
    private double fireLatitude;
    private int numberOfFiretrucks;

    public double getFireLatitude() {
        return fireLatitude;
    }

    public void setFireLatitude(double fireLatitude) {
        this.fireLatitude = fireLatitude;
    }

    public int getNumberOfFiretrucks() {
        return numberOfFiretrucks;
    }

    public void setNumberOfFiretrucks(int numberOfFiretrucks) {
        this.numberOfFiretrucks = numberOfFiretrucks;
    }
}
