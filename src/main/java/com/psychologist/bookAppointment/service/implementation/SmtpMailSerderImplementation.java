package com.psychologist.bookAppointment.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class SmtpMailSerderImplementation {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String to, String subject, String body) throws MessagingException, UnsupportedEncodingException{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String mailSubject = subject + " has sent a message";
        String mailContent = "<h2>este es el body</h2><h1>Hola jajaj </h1>"+ body + "<p> pero con este mensaje</p>";

        helper.setFrom("ceo@protobot.dev", "Julio Perez");
        helper.setSubject(mailSubject);
        helper.setTo(to);
        helper.setText(mailContent,true);

        javaMailSender.send(message);
    }
}
