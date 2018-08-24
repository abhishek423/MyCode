package bl;

import java.util.Properties;
//import javax.mail.Session;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PasswordResetOperation {

	public static void execute(String sub,String body,String toEmail) {
		
		try {
			
			System.out.println(toEmail);
			
			Properties props = System.getProperties();
			props.put("mail.smtp.host","smtp.gmail.com");
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.port","465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.port","465");
			props.put("mail.smtp.socketFactory.fallback","false");

			String fromEmail = "iamab423@gmail.com";
			String user = "iamab423@gmail.com";
			String password = "8759423079";
			
			Session mailSession = Session.getDefaultInstance(props,null);
			mailSession.setDebug(true);
			
			Message mailMsg = new MimeMessage(mailSession);
			mailMsg.setFrom(new InternetAddress(fromEmail));
			mailMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			mailMsg.setContent(body,"text/html");
			mailMsg.setSubject(body);
			
			Transport transport = mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", user, password);
			transport.sendMessage(mailMsg, mailMsg.getAllRecipients());
			System.out.println("mail Sent");
		
		} 
		catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

	}

}
