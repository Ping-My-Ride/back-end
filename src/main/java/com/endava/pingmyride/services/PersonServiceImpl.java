package com.endava.pingmyride.services;

import com.endava.pingmyride.model.Person;
import com.endava.pingmyride.repository.PersonRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jsilva.
 */
@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public Person findByUserName(String userName) {
    return personRepository.findByUserName(userName);
  }

  @Override
  public Optional<Person> findById(Long id) {
    return personRepository.findById(id);
  }
}
