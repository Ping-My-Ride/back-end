package com.endava.pingmyride.services;

import com.endava.pingmyride.controllers.RideRequest;
import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PingMyRideServiceImpl implements PingMyRideService {

    private GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyBW_4-OeWub-qsEyQBq91rO6uTA3OsWtGk")
            .build();

    public List<Driver> findDrivers(RideRequest rideRequest) {

//        for (List<LatLng> providersLatLngs : providersLatLonLists) {
//            SnappedPoint[] providerSnappedPoints = pingMyRideService.getRoadSnappedPoints(
//                    providersLatLngs.toArray(new LatLng[providersLatLngs.size()]));
//
//            LatLng[] latLngArray = Arrays.stream(providerSnappedPoints).map(
//                    snappedPoint -> snappedPoint.location).toArray(size -> new LatLng[size]);
//
//            System.out.println("------------- SnappedPoint -----------------");
//            System.out.println(providerSnappedPoints);
//
//            snappedProvidersPoints.add(latLngArray);
//        }
//
//        //SnappedPoint[] riderSnappedPoints = pingMyRideService.getRoadSnappedPoints(new LatLng[]{rider});
//        //System.out.println("------------- riderSnappedPoints -----------------");
//        //System.out.println(riderSnappedPoints);
//
//        //PlaceDetails placeDetails = pingMyRideService.getPlaceDetails("ChIJ_xhN2DWCRo4R9ok4DioM8jw");
//
//        for (LatLng[] snappedProvidersLatLng : snappedProvidersPoints) {
//            DistanceMatrix distanceMatrix = pingMyRideService.getWalkingDistanceMatrix(riderHome, snappedProvidersLatLng);
//            System.out.println("------------- distanceMatrix -----------------");
//            System.out.println(distanceMatrix);
//        }

        return null;

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
