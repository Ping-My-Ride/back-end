package com.endava.pingmyride.services;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 * @author jsilva.
 */
@Service
public class EmailServiceImpl implements EmailService {

  @Override
  public String sendContactEmail(String from, String to, String riderName, String driverName) throws IOException {
    final Email eFrom = new Email(from);
    final String subject = "PingMyRide: Hi, I'd like to commute with you!";
    final Email eTo = new Email(to);
    final Content content = new Content("text/plain",
        "Hello " + driverName + " Let's share your ride to the Office: att: " + riderName);
    Mail mail = new Mail(eFrom, subject, eTo, content);

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    Response response = null;
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
    return response != null ? String.valueOf(response.getStatusCode()) : "500";
  }

}
