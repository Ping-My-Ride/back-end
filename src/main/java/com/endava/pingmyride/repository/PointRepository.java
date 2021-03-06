package com.endava.pingmyride.repository;

import com.endava.pingmyride.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jsilva.
 */

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

}
