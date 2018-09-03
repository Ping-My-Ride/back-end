package com.endava.pingmyride.controllers;

import com.endava.pingmyride.services.Driver;
import com.endava.pingmyride.services.PingMyRideServiceImpl;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PingMyRideResController {

    @Autowired
    private PingMyRideServiceImpl pingMyRideService;

    @GetMapping("/hello-riders")
    public String rides() {
        return "Hello Ping My Riders!!";
    }

    @PostMapping("/find-rides")
    public List<RideResponse> finMyRides(@RequestBody RideRequest rideRequest) throws InterruptedException, ApiException, IOException {
        return pingMyRideService.findDriversForRider(rideRequest) ;
    }

    @PostMapping("/find-path")
    public SnappedPoint[] findPath(@RequestBody LatLng[] latLngs) throws InterruptedException, ApiException, IOException {
        return pingMyRideService.getRoadSnappedPoints(latLngs);
    }

}
