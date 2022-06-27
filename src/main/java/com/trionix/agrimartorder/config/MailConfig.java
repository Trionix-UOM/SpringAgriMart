package com.trionix.agrimartorder.config;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {
    @Bean
    public JavaMailSender configureJavaMailSender(){
        JavaMailSenderImpl javaMailSenderImpl= new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("");
        javaMailSenderImpl.setUsername("");
        javaMailSenderImpl.setPassword("");
        javaMailSenderImpl.setPort(567);

        Properties mailProperties= new Properties();
        mailProperties.put("mail.smtp.starttls.enable",true);
        mailProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        javaMailSenderImpl.setJavaMailProperties(mailProperties);

        return javaMailSenderImpl;
    }
}
