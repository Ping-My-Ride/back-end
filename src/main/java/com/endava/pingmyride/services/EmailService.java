package com.endava.pingmyride.services;

import java.io.IOException;

/**
 * @author jsilva.
 */
public interface EmailService {


  String sendContactEmail(String from, String to, String riderName, String driverName) throws IOException;
}
