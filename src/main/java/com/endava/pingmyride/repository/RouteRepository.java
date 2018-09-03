package com.endava.pingmyride.repository;

import com.endava.pingmyride.model.Route;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jsilva.
 */

@Repository
public interface RouteRepository  extends JpaRepository<Route,Long> {

  @Query(value = "select * from route where personid = ?1", nativeQuery = true)
  List<Route> findByPerson(Long personId);

}
