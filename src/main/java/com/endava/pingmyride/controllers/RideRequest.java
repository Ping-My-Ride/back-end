package com.endava.pingmyride.controllers;

import java.time.LocalDateTime;

public class RideRequest {

    public String userName;

    public float lat;

    public float lon;

    public LocalDateTime arrivalTime;

    public RideRequest() {
    }

    public RideRequest(String userName, float lat, float lon, LocalDateTime arrivalTime) {
        this.userName = userName;
        this.lat = lat;
        this.lon = lon;
        this.arrivalTime = arrivalTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
