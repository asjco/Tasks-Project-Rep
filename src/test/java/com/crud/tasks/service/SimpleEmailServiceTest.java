package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SimpleEmailServiceTest {

//    @InjectMocks
//    private SimpleEmailService simpleEmailService;
//
//    @Mock
//    private JavaMailSender javaMailSender;
//
//    @Test
//    public void shouldSendEmail(){
//        //Given
//        Mail mail = new Mail("test@test.com", "Test", "Test message", null);
//
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(mail.getMailTo());
//        simpleMailMessage.setSubject(mail.getSubject());
//        simpleMailMessage.setText(mail.getMessage());
//
//        //When
//        simpleEmailService.send(mail);
//
//        //Then
//        verify(javaMailSender, times(1)).send(simpleMailMessage);
//
//    }


}