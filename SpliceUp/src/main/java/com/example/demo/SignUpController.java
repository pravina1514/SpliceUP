/**
 * 
 */
package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "/signup")
public class SignUpController {

	@Autowired
	UserService service;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String registration(@ModelAttribute Login user) {
		user.getUserDetail().setUser(user);
		Login dbUser = service.saveUser(user);

		securityService.autologin(dbUser.getEmail(), dbUser.getPassword());

		return "redirect:/signup/home2";
	}

	@GetMapping
	public ModelAndView home2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		return modelAndView;
	}
<<<<<<< HEAD

	@GetMapping(value = "/home1")
	public ModelAndView home1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home1");
		return modelAndView;
	}

	@GetMapping(value = "/home2")
	public ModelAndView home2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home2");
		return modelAndView;
	}
=======
>>>>>>> branch 'master' of https://github.com/rasheee03/spliceup.git


<<<<<<< HEAD
	@GetMapping(value = "/loginuser")
	public ModelAndView inside(Map<String, Object> model) {
		Login user = new Login();
		user.setUserDetail(new UserDetail());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Login user) {
		user.getUserDetail().setUser(user);
		Login dbUser = service.saveUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("user", dbUser);
		return modelAndView;
	}

	@GetMapping
	public ModelAndView welcome(Map<String, Object> model) {
=======

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(Model model) {
>>>>>>> branch 'master' of https://github.com/rasheee03/spliceup.git
		Login user = new Login();
		user.setUserDetail(new UserDetail());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registeration");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

}
