package com.endava.pingmyride;

import com.endava.pingmyride.services.PingMyRideServiceImpl;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
public class PingMyRideServiceTest {

    @Autowired
    PingMyRideServiceImpl pingMyRideService;

    @Test
    public void rankBestRideProvidersByDistance() throws InterruptedException, ApiException, IOException {

        LatLng[] riderHome = {new LatLng(6.16868, -75.587397)};

        List<List<LatLng>> providersLatLonLists = new ArrayList<>();

        // p one
        List<LatLng> provider = new ArrayList<>();
        provider.add(new LatLng(6.168179, -75.585052));
        provider.add(new LatLng(6.168600, -75.585765));
        provider.add(new LatLng(6.169696, -75.587600));

        providersLatLonLists.add(provider);

        //p two
        provider = new ArrayList<>();
        provider.add(new LatLng(6.169158, -75.585207));
        provider.add(new LatLng(6.169801, -75.586242));
        provider.add(new LatLng(6.171449, -75.588777));
        providersLatLonLists.add(provider);

        List<LatLng[]> snappedProvidersPoints = new ArrayList<>();

        for (List<LatLng> providersLatLngs : providersLatLonLists) {
            SnappedPoint[] providerSnappedPoints = pingMyRideService.getRoadSnappedPoints(
                    providersLatLngs.toArray(new LatLng[providersLatLngs.size()]));

            LatLng[] latLngArray = Arrays.stream(providerSnappedPoints).map(
                    snappedPoint -> snappedPoint.location).toArray(size -> new LatLng[size]);

            System.out.println("------------- SnappedPoint -----------------");
            System.out.println(providerSnappedPoints);

            snappedProvidersPoints.add(latLngArray);
        }

        //SnappedPoint[] riderSnappedPoints = pingMyRideService.getRoadSnappedPoints(new LatLng[]{rider});
        //System.out.println("------------- riderSnappedPoints -----------------");
        //System.out.println(riderSnappedPoints);

        //PlaceDetails placeDetails = pingMyRideService.getPlaceDetails("ChIJ_xhN2DWCRo4R9ok4DioM8jw");

        for (LatLng[] snappedProvidersLatLng : snappedProvidersPoints) {
            DistanceMatrix distanceMatrix = pingMyRideService.getWalkingDistanceMatrix(riderHome, snappedProvidersLatLng);
            System.out.println("------------- distanceMatrix -----------------");
            System.out.println(distanceMatrix);
        }

    }
}