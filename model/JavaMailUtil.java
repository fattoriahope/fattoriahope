package model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	public static void sendMail (String dest, String mitt, String oggetto, String testoEmail)
		      throws MessagingException
		{
		    // Creazione di una mail session
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    
		    String userName = "ilparadisodeglianimali.gds@gmail.com";
		    String password ="ccds qxau ygqq bdgi";
		    
		       Authenticator auth = new Authenticator() {
		            public PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(userName, password);
		            }
		        };
		        
		        Session session = Session.getInstance(props, auth);

		    // Creazione del messaggio da inviare
		    MimeMessage message = new MimeMessage(session);
		    message.setSubject(oggetto);
		    message.setContent(testoEmail, "text/html");
		    //message.setText(testoEmail);
		   

		    // Aggiunta degli indirizzi del mittente e del destinatario
		    InternetAddress fromAddress = new InternetAddress(mitt);
		    InternetAddress toAddress = new InternetAddress(dest);
		    message.setFrom(fromAddress);
		    message.setRecipient(Message.RecipientType.TO, toAddress);

		    // Invio del messaggio
		    Transport.send(message);
		  }
}
