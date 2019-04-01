package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Contact")

public class ContactController {

	@Autowired
	UserService service;

	@GetMapping(value = "/con")
	public ModelAndView cont() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		// modelAndView.addObject("eve", user);

		return modelAndView;
	}

	@RequestMapping(value = "/con", method = RequestMethod.POST)
	public String registration(@ModelAttribute Contact user, Model model) {

		model.addAttribute("user", user);
		Contact con = service.saveUser(user);

		return "redirect:/Contact/con";

	}

}
