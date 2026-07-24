package com.example.mailTransfer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mailTransfer.dto.Transfer;
import com.example.mailTransfer.service.MailServiceWork;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/mail")
@AllArgsConstructor
public class MailController {

	private MailServiceWork service;

	@PostMapping
	public String sendMail(@RequestBody Transfer t) {
		service.sendMail(t);
		return "Successfully send";
	}
}
