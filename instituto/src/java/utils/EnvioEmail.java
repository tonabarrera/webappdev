/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author tonatihu
 * Created on 10-Mar-2019
 */
public class EnvioEmail {
    private String asunto;
    private String destinatario;
    private String mensaje;
    private Properties props;
    private static final String USERNAME = "webappdevtona@outlook.com";
    private static final String PASSWORD = "";
    private Session session;
    
    public EnvioEmail() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void enviar(Map<String, String> imagenes, Map<String, String> archivos) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            
            MimeMultipart multipart = new MimeMultipart("related");
            
            BodyPart bodyPartMensaje = new MimeBodyPart();
            bodyPartMensaje.setContent(mensaje, "text/html;charset=UTF-8");
            multipart.addBodyPart(bodyPartMensaje);
            
            for (Map.Entry<String, String> entrada : imagenes.entrySet()) {
                BodyPart bodyPartImagenes = new MimeBodyPart();
                DataSource fds = new FileDataSource(entrada.getValue());
                bodyPartImagenes.setDataHandler(new DataHandler(fds));
                bodyPartImagenes.setHeader("Content-ID", "<" + entrada.getKey() + ">");
                multipart.addBodyPart(bodyPartImagenes);
            }
            
            for (Map.Entry<String, String> entrada : archivos.entrySet()) {
                BodyPart bodyPartArchivos = new MimeBodyPart();
                DataSource fds2 = new FileDataSource(entrada.getValue());
                bodyPartArchivos.setDataHandler(new DataHandler(fds2));
                bodyPartArchivos.setFileName(entrada.getKey());
                multipart.addBodyPart(bodyPartArchivos);
            }
            
            message.setContent(multipart);
            
            Transport.send(message);
        } catch (AddressException ex) {
            Logger.getLogger(EnvioEmail.class.getName()).log(Level.SEVERE, "Error AddressException", ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnvioEmail.class.getName()).log(Level.SEVERE, "Error MessagingException", ex);
        }
    }
}
