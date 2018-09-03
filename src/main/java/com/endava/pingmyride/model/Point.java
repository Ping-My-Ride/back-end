package com.endava.pingmyride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author jsilva.
 */
@Entity
@Data
@Table(name="point")
public class Point {
  @Id
  private Long id;
  @Column(name="lat")
  private Double latitude;
  @Column(name="lng")
  private Double longitude;
  @Column(name="routeid")
  private Long routeId;

}
