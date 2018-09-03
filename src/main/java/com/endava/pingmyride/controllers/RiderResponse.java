package com.endava.pingmyride.controllers;

import com.endava.pingmyride.services.Driver;
import com.google.maps.model.DistanceMatrix;

public class RiderResponse {
    public Driver driver;

    public long walkingDuration;

    public DistanceMatrix distanceMatrix;

    public RiderResponse(Driver driver, long walkingDuration, DistanceMatrix distanceMatrix) {
        this.driver = driver;
        this.walkingDuration = walkingDuration;

        this.distanceMatrix = distanceMatrix;
    }


}
