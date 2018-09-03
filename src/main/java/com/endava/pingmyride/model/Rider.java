// Copyright (c) 2018 Sotheby's, Inc.
package com.endava.pingmyride.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author jsilva.
 */
@Entity
@Table(name="riders")
@Data
public class Rider {
  @Id
  private Long id;

}
