package com.endava.pingmyride.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author jsilva.
 */
@Entity
@Table(name="route")
@Data
public class Route {
  @Id
  private Long id;
  private String name;
  private String arrivalTime;
  private Person  person;
  private List<Point> points;
}
