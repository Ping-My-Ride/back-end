package com.endava.pingmyride.controllers;

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

    @GetMapping("/{user}/drivers")
    public List<RouteResponse> finMyRides(@PathVariable String user, @RequestParam double lat, @RequestParam double lng) throws InterruptedException, ApiException, IOException {

        return pingMyRideService.findDriversForRider(user, lat, lng) ;
    }

    @PostMapping("/find-path")
    public SnappedPoint[] findPath(@RequestBody LatLng[] latLngs) throws InterruptedException, ApiException, IOException {
        return pingMyRideService.getRoadSnappedPoints(latLngs);
    }

}
