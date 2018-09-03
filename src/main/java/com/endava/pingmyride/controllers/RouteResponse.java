package com.endava.pingmyride.controllers;

import com.endava.pingmyride.services.Driver;
import com.google.maps.model.DistanceMatrix;

public class RouteResponse {
    public Driver driver;

    public long walkingDuration;

    public DistanceMatrix distanceMatrix;

    public RouteResponse(Driver driver, long walkingDuration, DistanceMatrix distanceMatrix) {
        this.driver = driver;
        this.walkingDuration = walkingDuration;

        this.distanceMatrix = distanceMatrix;
    }


}
