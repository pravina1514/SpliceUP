/**
 * 
 */
package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@GetMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		return modelAndView;
	}

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

	@GetMapping(value = "/events")
	public ModelAndView events() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("services");
		return modelAndView;
	}

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
		Login user = new Login();
		user.setUserDetail(new UserDetail());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registeration");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Login user) {
		user.getUserDetail().setUser(user);
		Login dbUser = service.saveUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup");
		modelAndView.addObject("user", dbUser);
		return modelAndView;
	}

}
