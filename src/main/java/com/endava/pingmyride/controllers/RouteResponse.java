package com.endava.pingmyride.controllers;

import com.endava.pingmyride.model.Route;
import com.endava.pingmyride.services.Driver;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;

public class RouteResponse {
    public Route route;

    public long walkingDuration;

    public DistanceMatrixElement distanceMatrixElement;

    public int distanceMatrixIndex;

    public DistanceMatrix distanceMatrix;

    public RouteResponse(Route route, long walkingDuration, DistanceMatrixElement distanceMatrixElement,
                         int distanceMatrixIndex, DistanceMatrix distanceMatrix) {
        this.route = route;
        this.walkingDuration = walkingDuration;
        this.distanceMatrixElement = distanceMatrixElement;
        this.distanceMatrixIndex = distanceMatrixIndex;

        this.distanceMatrix = distanceMatrix;
    }


}
