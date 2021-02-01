package com.example.entity;

import java.io.Serializable;

public class PointBean implements Serializable {
    private static final long serialVersionUID = 6753768043914759530L;
    private double latitude;
    private double longitude;
    private PointBean() {
    }

    public PointBean(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
