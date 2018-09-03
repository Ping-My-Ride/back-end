package com.endava.pingmyride.repository;

import com.endava.pingmyride.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jsilva.
 */

@Repository
public interface RiderRepository  extends JpaRepository<Rider,Long> {

}
