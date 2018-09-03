package com.endava.pingmyride.services;

import com.google.maps.model.LatLng;

import java.time.LocalDateTime;

public class Driver {

    public String userName;

    public LatLng[] route;

    public LocalDateTime estimatedArrivalDateTime;

    public Driver(String userName, LatLng[] route, LocalDateTime estimatedArrivalDateTime) {
        this.userName = userName;
        this.route = route;
        this.estimatedArrivalDateTime = estimatedArrivalDateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LatLng[] getRoute() {
        return route;
    }

    public void setRoute(LatLng[] route) {
        this.route = route;
    }

    public LocalDateTime getEstimatedArrivalDateTime() {
        return estimatedArrivalDateTime;
    }

    public void setEstimatedArrivalDateTime(LocalDateTime estimatedArrivalDateTime) {
        this.estimatedArrivalDateTime = estimatedArrivalDateTime;
    }
}
