package com.endava.pingmyride.model;

import java.sql.Time;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author jsilva.
 */
@Data
@Entity
@Table(name = "route")
public class Route {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  //@Temporal(TemporalType.TIME)
  private Time arrival;
  @ManyToOne
  @JoinColumn(name = "personid")
  private Person person;
  @OneToMany(targetEntity = Point.class, mappedBy = "routeId", cascade = CascadeType.ALL)
  private List<Point> points;
}
