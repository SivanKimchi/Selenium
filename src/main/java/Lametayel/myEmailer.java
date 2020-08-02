package Lametayel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class myEmailer {


    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
    private static final String SMTP_AUTH_USER = GeneralProperties.myEmail;
    private static final String SMTP_AUTH_PWD = GeneralProperties.myEmailPass;


    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }

    }


    public void SendMail(String subject, String emailMessage) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", SMTP_HOST_NAME);
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(properties, auth);

        // MimeMessage object.
        MimeMessage message = new MimeMessage(mailSession);

        // Set From Field: adding senders email to from field.
        message.setFrom(new InternetAddress(GeneralProperties.myEmail));

        // Set To Field: adding recipient's email to from field.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("sivankimchi@gmail.com"));

        // Set Subject: subject of the email
        message.setSubject(subject);

        // set body of the email.
        message.setText(emailMessage);

        // Send email.
        Transport transport = mailSession.getTransport();
        // Connect the transport object.
        transport.connect();
        // Send the message.
        Transport.send(message);
        // Close the connection.
        transport.close();

        System.out.println("Mail successfully sent");
    }


  }
