package com.example.mailTransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.mailTransfer.dto.Transfer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailServiceWork {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String from;

	public void sendMail(Transfer t) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(from);
		msg.setTo(t.to());
		msg.setSubject(t.subject());
		msg.setText(t.body());

		mailSender.send(msg);

		log.info("Message send successfully to : " + t.to());

	}
}
