/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;
 
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 *
 * @author tonatihu
 * Created on 17-Feb-2019
 */

public class EnvioEmail {
	private final Properties properties = new Properties();
	
	private String password;
 
	private Session session;
        
        private String mensaje;
        private String destinatario;
        private String asunto;
        
        private String emisor="carlostonatihu@gmail.com";
        
	private void init() {
 
            properties.put("mail.smtp.host", "mail.gmail.com");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.port", 25);
            properties.put("mail.smtp.mail.sender", emisor);
            properties.put("mail.smtp.user", "usuario");
            properties.put("mail.smtp.auth", "true");

            session = Session.getDefaultInstance(properties);
	}
 
	public void sendEmail(){
 
            init();
            try{
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                message.setSubject(asunto);
                message.setText(mensaje);
                Transport t = session.getTransport("smtp");
                t.connect((String)properties.get("mail.smtp.user"), "password");
                t.sendMessage(message, message.getAllRecipients());
                t.close();
            }catch (MessagingException me){
                //Aqui se deberia o mostrar un mensaje de error o en lugar
                //de no hacer nada con la excepcion, lanzarla para que el modulo
                //superior la capture y avise al usuario con un popup, por ejemplo.
                return;
            }
	}
}
