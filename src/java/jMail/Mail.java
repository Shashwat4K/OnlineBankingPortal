/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jMail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 *
 * @author Vibhav
 */
public class Mail {
String to = null;
String from = null;
String message = null;
String subject = null;
String smtpServ = null;

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSmtpServ(String smtpServ) {
        this.smtpServ = smtpServ;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public String getSmtpServ() {
        return smtpServ;
    }
    public int sendMail(){
        try
        {
            Properties props = System.getProperties();
              // -- Attaching to default Session, or we could start a new one --
              props.put("mail.transport.protocol", "smtp" );
              props.put("mail.smtp.starttls.enable","true" );
              props.put("mail.smtp.host",smtpServ);
              props.put("mail.smtp.auth", "true" );
              props.put("mail.smtp.port","587");
              System.out.println("1\t" + smtpServ +"\t" + to +"\t" + from + "\t" + message);
              Authenticator auth = new SMTPAuthenticator();
              Session session = Session.getInstance(props, auth);
              // -- Create a new message --
              MimeMessage msg = new MimeMessage(session);
              // -- Set the FROM and TO fields --
              msg.setFrom(new InternetAddress(from));
              System.out.println("2\t" + smtpServ +"\t" + to +"\t" + from + "\t" + message);
              msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
              msg.setSubject(subject);
              System.out.println("3\t" + smtpServ +"\t" + to +"\t" + from + "\t" + message);
              msg.setText(message);
              System.out.println("4\t" + smtpServ +"\t" + to +"\t" + from + "\t" + message);
              // -- Set some other header information --
              //msg.setHeader("MyMail", "Mr. Vibhav Deshpande" );
              //msg.setSentDate(new Date());
              // -- Send the message --
              System.out.println(message);
              Transport.send(msg);
              System.out.println("Message sent to"+to+" OK." );
              return 0;
        }
        catch (MessagingException ex)
        {
            System.out.println(ex);
            System.out.println("EXCEPTION!!!!");
          return -1;
        }
  }

// Also include an inner class that is used for authentication purposes

private class SMTPAuthenticator extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username =  "kbonline1234@gmail.com";           // specify your email id here (sender's email id)
            String password = "KBonline";                                      // specify your password here
            return new PasswordAuthentication(username, password);
        }
  }

}
