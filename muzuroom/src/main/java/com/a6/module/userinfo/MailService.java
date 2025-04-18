package com.a6.module.userinfo;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class MailService {
	
	@Autowired
	JavaMailSender javaMailSender;

//	회원가입 축하 메일
    public void sendMailWelcome() throws Exception{

    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setFrom("sechan8896@gmail.com"); 
    	mimeMessageHelper.setTo("radeark@naver.com");
    	mimeMessageHelper.setSubject("회원가입");
    	mimeMessageHelper.setText("그리팅스", true); 
    	javaMailSender.send(mimeMessage);
    	
    }
}
