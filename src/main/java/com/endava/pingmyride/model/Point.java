package com.endava.pingmyride.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author jsilva.
 */
@Entity
@Table(name="point")
@Data
public class Point {
  private Double latitude;
  private Double longitude;
  private Route route;

}
