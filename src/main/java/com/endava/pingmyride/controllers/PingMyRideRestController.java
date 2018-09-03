package com.endava.pingmyride.controllers;

import com.endava.pingmyride.model.Notification;
import com.endava.pingmyride.model.Person;
import com.endava.pingmyride.model.Route;
import com.endava.pingmyride.services.EmailService;
import com.endava.pingmyride.services.PersonService;
import com.endava.pingmyride.services.PingMyRideService;
import com.endava.pingmyride.services.RouteService;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingMyRideRestController {

  @Autowired
  private PingMyRideService pingMyRideService;

  @Autowired
  private RouteService routeService;

  @Autowired
  private PersonService personService;

  @Autowired
  private EmailService emailService;

  @GetMapping("/hello-riders")
  public String rides() {
    return "Hello Ping My Riders!!";
  }

  @GetMapping("/{user}/drivers")
  public List<RouteResponse> finMyRides(@PathVariable String user, @RequestParam double lat,
      @RequestParam double lng) throws InterruptedException, ApiException, IOException {
    return pingMyRideService.findDriversForRider(user, lat, lng);
  }

  @PostMapping("/find-path")
  public SnappedPoint[] findPath(@RequestBody LatLng[] latLngs)
      throws InterruptedException, ApiException, IOException {
    return pingMyRideService.getRoadSnappedPoints(latLngs);
  }

  @RequestMapping(path = "/routes/{userName}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Route>> findRoutesByUsername(
      @PathVariable String userName, HttpServletRequest request) {
    ResponseEntity<List<Route>> responseEntity =
        new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    Person user = personService.findByUserName(userName);

    if (user != null) {
      List<Route> routes = routeService.findByPerson(user.getId());
      responseEntity = new ResponseEntity<>(routes, HttpStatus.OK);
    }
    return responseEntity;
  }

  @GetMapping(path = "/user/{userName}")
  public Person findPersonByUserName(@PathVariable String userName) {
    return personService.findByUserName(userName);
  }

  @PostMapping("/user")
  public Long createPerson(@RequestBody Person person) {
    return personService.save(person).getId();
  }

  @GetMapping("/routes")
  public List<Route> findAllRoutes() {
    return routeService.findAll();
  }

  @GetMapping("/routes/{id}")
  public Optional<Route> findRouteById(@PathVariable Long id) {
    return routeService.findById(id);
  }

  @PostMapping("/routes")
  public Long postRoute(@RequestBody Route route) {
    return routeService.save(route).getId();
  }

  @PostMapping("/sendNotification")
  public void sendEmail(@RequestBody Notification notification) {
    try {
      emailService.sendContactEmail(notification.getFrom(), notification.getTo(),
          notification.getRiderName(), notification.getDriverName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
