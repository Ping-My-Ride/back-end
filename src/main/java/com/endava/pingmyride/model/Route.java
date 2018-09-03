package com.endava.pingmyride.model;

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
  private String arraivalTime;
  private Person  person;
}
