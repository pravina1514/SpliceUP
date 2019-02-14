package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	EventRepository eventRepo;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/createEvent", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute Event event) {
		eventRepo.save(event);
		return "redirect:/event/services";

	}

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

	@GetMapping(value = "/home")
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		return modelAndView;
	}

	@GetMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");

		return modelAndView;
	}

	@GetMapping(value = "/services")
	public ModelAndView services() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("services");

		return modelAndView;
	}

	@GetMapping(value = "/gallery")
	public ModelAndView gallery() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("gallery");

		return modelAndView;
	}

	@GetMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");

		return modelAndView;
	}

}
