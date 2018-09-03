package com.endava.pingmyride.services;

import com.endava.pingmyride.controllers.RouteResponse;
import com.endava.pingmyride.repository.DriverRepository;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.RoadsApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PingMyRideServiceImpl implements PingMyRideService {

    private GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyBW_4-OeWub-qsEyQBq91rO6uTA3OsWtGk")
            .build();

    @Autowired
    private DriverRepository driverRepository;

    public List<RouteResponse> findDriversForRider(String user, double lat, double lng)
            throws InterruptedException, ApiException, IOException {

        List<Driver> drivers = driverRepository.findAllDrivers();

        PlaceDetails placeDetails = getPlaceDetails("ChIJ_xhN2DWCRo4R9ok4DioM8jw");

        List<RouteResponse> rideResponses = new ArrayList<>();

        for (Driver driver : drivers) {
            DistanceMatrix distanceMatrix = getWalkingDistanceMatrix(new LatLng[]{new LatLng(lat, lng)}, driver.route);


            int minIndex = 0;
            DistanceMatrixElement minDistanceMatrixElement = distanceMatrix.rows[0].elements[minIndex];

            for(int i=1; i< distanceMatrix.rows[0].elements.length; i++) {
                        if (minDistanceMatrixElement.duration.inSeconds > distanceMatrix.rows[0].elements[i].duration.inSeconds) {
                            minDistanceMatrixElement = distanceMatrix.rows[0].elements[i];
                            minIndex = i;
                        }
            }

            RouteResponse routeResponse = new RouteResponse(driver, minDistanceMatrixElement.duration.inSeconds,
                    minDistanceMatrixElement, minIndex, distanceMatrix);

            rideResponses.add(routeResponse);

        }


        Collections.sort(rideResponses, (response1, response2) -> {
            if (response1.walkingDuration < response2.walkingDuration) {
                return -1;
            } else if (response1.walkingDuration > response2.walkingDuration) {
                return 1;
            } else {
                return 0;
            }
        });

        return rideResponses;

    }

    public SnappedPoint[] getRoadSnappedPoints(LatLng[] latLngs) throws InterruptedException, ApiException, IOException {

        SnappedPoint[] snappedPoints = RoadsApi.snapToRoads(context, true, latLngs).await();

        for (SnappedPoint snappedPoint : snappedPoints) {
            PlaceDetails placeDetails = getPlaceDetails(snappedPoint.placeId);
        }

        return snappedPoints;
    }


    public PlaceDetails getPlaceDetails(String placeId) throws InterruptedException, ApiException, IOException {
        PlaceDetails placeDetails = PlacesApi.placeDetails(context, placeId).await();
        return placeDetails;
    }

    public DistanceMatrix getWalkingDistanceMatrix(LatLng[] origins, LatLng[] destinations)
            throws InterruptedException, ApiException, IOException {

        DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(context)
                .origins(origins)
                .destinations(destinations)
                .mode(TravelMode.WALKING)
                .await();

        return distanceMatrix;
    }


}
