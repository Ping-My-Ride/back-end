package com.endava.pingmyride.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author jsilva.
 */
@Entity
@Table(name="person")
@Data
public class Person {
  @Id
  private Long id;
  private String userName;
  private String password;
  private String phone;

}
