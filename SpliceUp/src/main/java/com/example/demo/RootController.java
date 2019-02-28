package com.example.demo;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	@Autowired
	private SmtpMailSender smtpMailSender;

	@GetMapping("/send-mail")
	public void sendMail() throws MessagingException {
		smtpMailSender.send("rashi.150410107121@gmail.com", "testing-subject", "hey there-body");
	}

}
