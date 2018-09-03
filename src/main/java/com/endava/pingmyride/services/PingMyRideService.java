package com.endava.pingmyride.services;

import com.endava.pingmyride.controllers.RideRequest;
import com.endava.pingmyride.controllers.RideResponse;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.SnappedPoint;

import java.io.IOException;
import java.util.List;

public interface PingMyRideService {

    List<RideResponse> findDriversForRider(String user, double lat, double lng) throws InterruptedException, ApiException, IOException;

    SnappedPoint[] getRoadSnappedPoints(LatLng[] latLngs) throws InterruptedException,
            ApiException, IOException;

    PlaceDetails getPlaceDetails(String placeId) throws InterruptedException, ApiException, IOException;

    DistanceMatrix getWalkingDistanceMatrix(LatLng[] origins, LatLng[] destinations) throws InterruptedException,
            ApiException, IOException;




}
