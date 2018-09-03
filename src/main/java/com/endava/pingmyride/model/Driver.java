package com.endava.pingmyride.model;

import javax.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author jsilva.
 */
@Entity
@Data
public class Driver {
  @Id
  private Long id;

}
