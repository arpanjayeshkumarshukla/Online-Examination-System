package Common;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendEmail {
    public static void send(String to,String subject,String msg) {
        return ;
      /*String from = "Notifications";
      final String username = "oap.notifications@gmail.com";
      final String password = "automaticemail";
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

      try {
	   Message message = new MimeMessage(session);
	   message.setFrom(new InternetAddress(from));
	   message.setRecipients(Message.RecipientType.TO,
           InternetAddress.parse(to));
	   message.setSubject(subject);
	   message.setText(msg);
	   Transport.send(message);
           JOptionPane.showMessageDialog(null,"Email sent to "+to+" with the subject "+subject+".","Mail Delivery Message",JOptionPane.INFORMATION_MESSAGE);
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Email could not be delivered to the recipient "+to+" due to the following error \n"+e,"Mail Delivery Failure",JOptionPane.ERROR_MESSAGE);
      }*/
   }
}