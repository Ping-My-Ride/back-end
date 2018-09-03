// Copyright (c) 2018 Sotheby's, Inc.
package com.endava.pingmyride.services;

import com.endava.pingmyride.model.Route;
import java.util.List;
import java.util.Optional;

/**
 * @author jsilva.
 */
public interface RouteService {

  List<Route> findByPerson(Long personId);
  Optional<Route> findById(Long id);
  Route save(Route route);




}
