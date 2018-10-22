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
	UserMasterRepository repo;

	@GetMapping
	public ModelAndView welcome(Map<String, Object> model) {
		UserMaster user = new UserMaster();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute UserMaster user) {
		user.getUserDetail().setUser(user);
		UserMaster dbUser=repo.save(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup");
		modelAndView.addObject("user", dbUser);
		return modelAndView;
	}

}
