package com.endava.pingmyride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author jsilva.
 */
@Entity
@Data
@Table(name="point")
public class Point {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column(name="lat")
  private Double latitude;
  @Column(name="lng")
  private Double longitude;
  @NotNull
  @ManyToOne
  @Column(name="routeid")
  private Long routeId;

}
