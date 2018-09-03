package com.endava.pingmyride.repository;


import com.endava.pingmyride.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jsilva.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
