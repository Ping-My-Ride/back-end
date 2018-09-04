package com.endava.pingmyride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author jsilva.
 */
@Data
@Entity
@Table(name = "point")
public class Point {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "lat")
  private Double latitude;
  @Column(name = "lng")
  private Double longitude;
  //@NotNull
  //@JoinColumn(name = "routeid")
  //@ManyToOne(fetch = FetchType.LAZY)
  @Column(name = "routeid")
  private Long routeId;
}
