package com.endava.pingmyride.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author jsilva.
 */
@Entity
@Table(name="point")
@Data
public class Point {
  private Long id;
  private Double latitute;
  private Double Longitude;
  private Route route;

}
