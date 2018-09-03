package com.endava.pingmyride.model;

import lombok.Data;

/**
 * @author jsilva.
 */
@Data
public class Notification {

  private String from;
  private String to;
  private String driverName;
  private String riderName;

}
