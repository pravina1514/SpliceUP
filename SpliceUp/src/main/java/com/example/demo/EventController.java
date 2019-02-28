package com.example.demo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	EventRepository eventRepo;

	@Autowired
	CitiesRepository cityRepo;

	@Autowired
	UserMasterRepository userRepo;

	@Autowired
	UserService service;

	public static String uploadDir = "E:\\sts\\Workspace\\maven.1535549954053\\SpliceUp\\src\\main\\resources\\static\\images\\upload";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@GetMapping(value = "/createEvent")
	public ModelAndView contact() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		modelAndView.addObject("cities", cityRepo.findAll());

		return modelAndView;
	}

	@RequestMapping(value = "/createEvent", method = RequestMethod.POST)
	public String createEvent(@ModelAttribute Event event, @RequestParam("eventImage") MultipartFile file) {
		event.setEventHost(service.getLoggedInUser());
		Path mpath = Paths.get(uploadDir, file.getOriginalFilename());
		try {
			java.nio.file.Files.write(mpath, file.getBytes());
			event.setImage("/images/upload/" + file.getOriginalFilename());
		} catch (Exception e) {
			System.out.print(e);
		}
		eventRepo.save(event);

		return "redirect:/event/services";

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
		modelAndView.addObject("contact", eventRepo.findAll());

		return modelAndView;
	}

	@GetMapping(value = "/eventDetail")
	public ModelAndView eventDetail() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("eventdetail");

		return modelAndView;
	}

	@GetMapping(value = "/chat1")
	public ModelAndView chat() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("chat1");

		return modelAndView;
	}

}
