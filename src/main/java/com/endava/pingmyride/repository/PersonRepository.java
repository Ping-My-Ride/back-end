package com.endava.pingmyride.repository;



import com.endava.pingmyride.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jsilva.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  Person findByUsername(String userName);

}
