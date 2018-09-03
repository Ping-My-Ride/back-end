package com.endava.pingmyride.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * @author jsilva.
 */
@Entity
@Table(name = "route")
@Data
@Builder
public class Route {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String arrival;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "personid")
  private Person person;
  @OneToMany(targetEntity = Point.class, mappedBy = "routeId", cascade = CascadeType.ALL)
  private List<Point> points;
}
