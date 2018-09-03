package com.endava.pingmyride.controllers;

import com.endava.pingmyride.model.Person;
import com.endava.pingmyride.model.Route;
import com.endava.pingmyride.services.Driver;
import com.endava.pingmyride.services.PersonService;
import com.endava.pingmyride.services.PingMyRideServiceImpl;
import com.endava.pingmyride.services.RouteService;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingMyRideResController {

    @Autowired
    private PingMyRideServiceImpl pingMyRideService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private PersonService personService;

    @GetMapping("/hello-riders")
    public String rides() {
        return "Hello Ping My Riders!!";
    }

    @PostMapping("/find-rides")
    public List<Driver> finMyRides(@RequestBody RideRequest rideRequest) {
        return pingMyRideService.findDrivers(rideRequest);
    }

    @PostMapping("/find-path")
    public SnappedPoint[] findPath(@RequestBody LatLng[] latLngs) throws InterruptedException, ApiException, IOException {
        return pingMyRideService.getRoadSnappedPoints(latLngs);
    }


    @RequestMapping(path = "/routes/{userName}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Route>> findRoutesByUsername(
        @PathVariable String userName, HttpServletRequest request) {
        ResponseEntity<List<Route>> responseEntity =
            new ResponseEntity<List<Route>>(HttpStatus.BAD_REQUEST);

        Person user = personService.findByUserName(userName);

        if (user != null) {
            List<Route> routes = routeService.findByPerson(user.getId());
            responseEntity = new ResponseEntity<List<Route>>(routes, HttpStatus.OK);
        }
        return responseEntity;
    }

}
