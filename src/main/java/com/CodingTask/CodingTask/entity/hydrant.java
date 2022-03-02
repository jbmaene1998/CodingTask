package com.CodingTask.CodingTask.entity;

public class hydrant {
    private String unitId;
    private double longitude;
    private double latitude;

    public hydrant(String unitId, double longitude, double latitude) {
        this.unitId = unitId;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "hydrant{" +
                "unitId='" + unitId + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
