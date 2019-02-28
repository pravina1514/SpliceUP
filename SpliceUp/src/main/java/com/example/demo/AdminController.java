package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping(value = "/admin")

public class AdminController {

	@Autowired
	UserMasterRepository userRepo;

	@GetMapping(value = "/ar")
	public ModelAndView adminrecord() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("List_Of_Users", userRepo.findAll());
		modelAndView.setViewName("adminrecord");
		return modelAndView;
	}

	@GetMapping(value = "/viewDelete/{recordId}")
	public ModelAndView viewdelete(@PathVariable Long recordId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminrecord", userRepo.findById(recordId).get());

		modelAndView.setViewName("ar_viewdelete");

		return modelAndView;

	}

	@RequestMapping(value = "/delete/{recordId}", method = RequestMethod.GET)
	public String delete(@PathVariable Long recordId) {

		userRepo.deleteById(recordId);

		return "redirect:/admin/ar";
	}

}
