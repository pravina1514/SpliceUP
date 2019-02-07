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
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	UserService service;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String registration(@ModelAttribute Login user,Model model) {
		Login existingUser = service.findUserByEmail(user.getEmail());
		if (existingUser != null) {

			model.addAttribute("user", user);
			return "registration";

		} else {
			user.getUserDetail().setRole("ROLE_USER");
			user.getUserDetail().setUser(user);
			Login dbUser = service.saveUser(user);

			securityService.autologin(dbUser.getEmail(), dbUser.getPassword());
			return "redirect:/event/services";


		}
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(Model model) {
		Login user = new Login();
		user.setUserDetail(new UserDetail());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registeration");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@GetMapping
	public ModelAndView home2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
