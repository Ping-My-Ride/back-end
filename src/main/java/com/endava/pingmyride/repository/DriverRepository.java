package com.endava.pingmyride.repository;

import com.endava.pingmyride.controllers.RideRequest;
import com.endava.pingmyride.services.Driver;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverRepository {


    public List<Driver> findAllDrivers() {

        List<Driver> possibleRides = new ArrayList<>();

        // p one
        List<LatLng> provider = new ArrayList<>();
        provider.add(new LatLng(6.168179, -75.585052));
        provider.add(new LatLng(6.168600, -75.585765));
        provider.add(new LatLng(6.169696, -75.587600));

        possibleRides.add(new Driver("Marian Antonieta", provider.toArray(new LatLng[provider.size()]), LocalDateTime.now()));

        //p two
        provider = new ArrayList<>();
        provider.add(new LatLng(6.169158, -75.585207));
        provider.add(new LatLng(6.169801, -75.586242));
        provider.add(new LatLng(6.171449, -75.588777));

        possibleRides.add(new Driver("Esperanza Gomez", provider.toArray(new LatLng[provider.size()]), LocalDateTime.now()));

        return possibleRides;

    }



}
