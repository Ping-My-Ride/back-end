// Copyright (c) 2018 Sotheby's, Inc.
package com.endava.pingmyride.services;

import com.endava.pingmyride.model.Person;
import java.util.Optional;

/**
 * @author jsilva.
 */
public interface PersonService {
  public Person findByUserName(String userName);
  public Optional<Person> findById(Long id);
}
