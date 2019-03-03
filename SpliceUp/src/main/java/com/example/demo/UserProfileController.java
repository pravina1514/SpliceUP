package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/profile")
public class UserProfileController {
	
	@Autowired
	UserService service;
	
	@Autowired
	UserMasterRepository userRepo;

	
	
	
	@GetMapping(value = "/userProfile")
	public ModelAndView profile() {
		Login user = new Login();
		user.setUserDetail(new UserDetail());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profile");
		modelAndView.addObject("user", service.getLoggedInUser());
		

		return modelAndView;
	}

	//hiii
	

	@PostMapping(value = "/updateuser")
	public String updateuser(@ModelAttribute Login user) {
		//Login existingUser = service.findUserByEmail(user.getEmail());
		//Login existingUser =service.getLoggedInUser();
		
		//user.setUserDetail(service.getLoggedInUser());
		user.getUserDetail().setLogin(user);
		userRepo.save(user);
		
		
		
		//Login user = new Login();
		//user.setUserDetail(new UserDetail());
		//ModelAndView modelAndView = new ModelAndView();
		
		//modelAndView.setViewName("profile");
		//modelAndView.addObject("user", service.getLoggedInUser());
		

		return "redirect:/profile/userProfile";
	}

}
