package com.endava.pingmyride.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String arrival;
  @JoinColumn(referencedColumnName = "personid", nullable = false)
  private Person  person;
  @OneToMany(targetEntity = Point.class, mappedBy = "routeId", cascade = CascadeType.ALL)
  private List<Point> points;
}
