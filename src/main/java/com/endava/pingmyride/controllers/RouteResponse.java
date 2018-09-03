package com.endava.pingmyride.controllers;

import com.endava.pingmyride.services.Driver;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;

public class RouteResponse {
    public Driver driver;

    public long walkingDuration;

    public DistanceMatrixElement distanceMatrixElement;

    public int distanceMatrixIndex;

    public DistanceMatrix distanceMatrix;

    public RouteResponse(Driver driver, long walkingDuration, DistanceMatrixElement distanceMatrixElement,
                         int distanceMatrixIndex, DistanceMatrix distanceMatrix) {
        this.driver = driver;
        this.walkingDuration = walkingDuration;
        this.distanceMatrixElement = distanceMatrixElement;
        this.distanceMatrixIndex = distanceMatrixIndex;

        this.distanceMatrix = distanceMatrix;
    }


}
