// Copyright (c) 2018 Sotheby's, Inc.
package com.endava.pingmyride.services;

import com.endava.pingmyride.model.Route;
import com.endava.pingmyride.repository.RouteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jsilva.
 */
public class RouteServiceImpl implements RouteService {

  @Autowired
  private RouteRepository routeRepository;

  @Override
  public List<Route> findByPerson(Long personId) {
    return routeRepository.findByPerson(personId);
  }

  @Override
  public Optional<Route> findById(Long id) {
    return routeRepository.findById(id);
  }

  @Override
  public Route save(Route route) {
    return routeRepository.save(route);
  }
}