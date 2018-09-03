package com.endava.pingmyride.controllers;

import com.endava.pingmyride.services.Driver;
import com.google.maps.model.DistanceMatrix;

public class RideResponse {
    public Driver driver;

    public long walkingDuration;

    public DistanceMatrix distanceMatrix;

    public RideResponse(Driver driver, long walkingDuration, DistanceMatrix distanceMatrix) {
        this.driver = driver;
        this.walkingDuration = walkingDuration;

        this.distanceMatrix = distanceMatrix;
    }


}
