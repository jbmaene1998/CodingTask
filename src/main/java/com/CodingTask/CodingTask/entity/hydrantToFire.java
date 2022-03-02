package com.CodingTask.CodingTask.entity;

public class hydrantToFire {
    private  long kmToFire;
    private String UnitId;

    public hydrantToFire(long kmToFire, String unitId) {
        this.kmToFire = kmToFire;
        UnitId = unitId;
    }

    @Override
    public String toString() {
        return "hydrantToFire{" +
                "kmToFire=" + kmToFire +
                ", UnitId='" + UnitId + '\'' +
                '}';
    }

    public long getKmToFire() {
        return kmToFire;
    }

    public void setKmToFire(long kmToFire) {
        this.kmToFire = kmToFire;
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String unitId) {
        UnitId = unitId;
    }
}
