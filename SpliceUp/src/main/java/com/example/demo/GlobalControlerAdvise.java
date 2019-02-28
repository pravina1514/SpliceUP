package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice

public class GlobalControlerAdvise {

	@Autowired
	UserService service;

	@ModelAttribute
	public void handleRequest(HttpServletRequest request, Model model) {
		Login l = service.getLoggedInUser();
		String r = service.getLoggedInUserRole();
		if (l != null) {
			model.addAttribute("userName", l.getEmail());

			model.addAttribute("userRole", r);
		} else {
			model.addAttribute("userName", "");
			model.addAttribute("userRole", "");

		}
	}
}
