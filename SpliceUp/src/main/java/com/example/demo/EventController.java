package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/event")
public class EventController {

	@GetMapping(value = "/hostEvent")
	public ModelAndView hostEvent() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("EventHostForm");

		return modelAndView;

	}

	@GetMapping(value = "/eventDetail")
	public ModelAndView eventDetail() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("EventDetails");

		return modelAndView;
	}

	@GetMapping(value = "/eventList")
	public ModelAndView eventList() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("EventList");

		return modelAndView;
	}

}
