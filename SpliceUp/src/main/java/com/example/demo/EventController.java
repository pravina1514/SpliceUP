package com.example.demo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	private SmtpMailSender smtpMailSender;

	@Autowired
	EventRepository eventRepo;

	@Autowired
	CitiesRepository cityRepo;

	@Autowired
	UserMasterRepository userRepo;

	@Autowired
	UserService service;

	@Autowired
	ParticipantRepository participantsRepo;

	@Autowired
	CommentRepository commentRepo;

	@Autowired
	ParticipantsGroupRepository groupRepo;

	public static String uploadDir = "E:\\sts\\Workspace\\maven.1535549954053\\SpliceUp\\src\\main\\resources\\static\\images\\upload";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@GetMapping(value = "/home")
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");

		return modelAndView;
	}

	@GetMapping(value = "/filter")
	public ModelAndView filter() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("filter");

		return modelAndView;
	}

	@GetMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");

		return modelAndView;
	}

	@GetMapping(value = "/chat1")
	public ModelAndView chat() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("chat1");

		return modelAndView;
	}

	@GetMapping(value = "/createEvent")
	public ModelAndView createEvent() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("createEvent");
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

	@RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
	public String updateEvent(@ModelAttribute Event event, Model model) {
		event.setEventHost(service.getLoggedInUser());

		Event dbEvent = eventRepo.save(event);
		model.addAttribute("emailSent", "false");

		if (!CollectionUtils.isEmpty(dbEvent.getParticipants())) {
			for (Participant p : dbEvent.getParticipants()) {

				try {
					smtpMailSender.send(p.getUser().getEmail(), event.getName(),
							"changes in event you have participated, please visit website for details");
					model.addAttribute("emailSent", "true");

				}

				catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					model.addAttribute("emailSent", "false");

				}

			}
		}

		return "redirect:/event/services";

	}

	@GetMapping(value = "/edit/{eventId}")
	public ModelAndView edit(@PathVariable Long eventId) {
		Event event = eventRepo.findById(eventId).get();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit");
		modelAndView.addObject("contact", event);
		modelAndView.addObject("cities", cityRepo.findAll());

		return modelAndView;

	}

	@RequestMapping(value = "/delete/{eventId}", method = RequestMethod.GET)
	public String delete(@PathVariable Long eventId) {

		eventRepo.deleteEventFromDB(eventId);

		return "redirect:/event/services";
	}

	@GetMapping(value = "/services")
	public ModelAndView services(@RequestParam(value = "cityName", required = false) String cityName,
			@RequestParam(value = "location", required = false) String location) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("events");
		modelAndView.addObject("cities", cityRepo.findAll());

		List<Event> eventList = eventRepo.findAll();
		List<Event> nonExpiredEvents = new ArrayList<>();
		for (Event event : eventList) {
			if (event.getE_date() != null && event.getS_date() != null && event.getE_date().after(new Date())) {
				nonExpiredEvents.add(event);
			}
		}
		eventList = nonExpiredEvents;
		List<Event> filteredList = new ArrayList<>();
		if (!StringUtils.isEmpty(cityName) || !StringUtils.isEmpty(location)) {
			for (Event event : eventList) {
				if (!StringUtils.isEmpty(cityName) && event.getCity().getName().equalsIgnoreCase(cityName)) {
					filteredList.add(event);
				} else if (!StringUtils.isEmpty(location) && event.getLocation().contains(location)) {
					filteredList.add(event);

				}

			}
			modelAndView.addObject("contact", filteredList);

		} else {
			modelAndView.addObject("contact", eventList);

		}

		return modelAndView;
	}

	@GetMapping(value = "/services/{eventId}")
	public ModelAndView services(@PathVariable Long eventId) {
		Event event = eventRepo.findById(eventId).get();
		List<Participant> eventParti = participantsRepo.findByEvent(event);
		List<Comment> eventComments = commentRepo.findByEvent(event);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("eventDetails");

		modelAndView.addObject("contact", event);
		modelAndView.addObject("entries", eventParti);
		modelAndView.addObject("eventComments", eventComments);

		return modelAndView;
	}

	@GetMapping(value = "/plist")
	public ModelAndView plist() {
		Login u = service.getLoggedInUser();
		List<Participant> user = participantsRepo.findByUser(u);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("plist");
		modelAndView.addObject("eve", user);

		return modelAndView;
	}

	@RequestMapping(value = "/takePart/{eventId}", method = RequestMethod.GET)
	public String takePart(@PathVariable Long eventId) {
		Event event = eventRepo.findById(eventId).get();
		Login user = service.getLoggedInUser();

		Participant p = new Participant();
		p.setEvent(event);
		p.setPayment(false);
		p.setUser(user);
		participantsRepo.save(p);
		return "redirect:/event/services";

	}

	/*
	 * @RequestMapping(value = "/delete/{commentId}", method = RequestMethod.GET)
	 * public String deleteComment(@PathVariable Long commentId) {
	 * 
	 * commentRepo.deleteCommentFromDB(commentId); return
	 * "redirect:/event/services"; }
	 */

	@RequestMapping(value = "/postComment", method = RequestMethod.POST)
	public String createEvent(@ModelAttribute Comment comment) {
		Event event = eventRepo.findById(comment.getEvent().getEid()).get();
		Login user = service.getLoggedInUser();
		comment.setUser(user);
		comment.setEvent(event);
		commentRepo.save(comment);
		return "redirect:/event/services/" + event.getEid();

	}

	@GetMapping(value = "/contact")
	public ModelAndView cont() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		// modelAndView.addObject("eve", user);

		return modelAndView;
	}

	@GetMapping(value = "/group/{eventId}")
	public ModelAndView group(@PathVariable Long eventId) {
		Event event = eventRepo.findById(eventId).get();
		List<Participant> eventParti = participantsRepo.findByEvent(event);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("group");
		modelAndView.addObject("contact", event);
		modelAndView.addObject("eventId", eventParti);
		modelAndView.addObject("contact", event);
		ParticipantsGroup p = new ParticipantsGroup();
		p.setEvent(event);
		modelAndView.addObject("entries", eventParti);

		modelAndView.addObject("partGroup", p);

		return modelAndView;

	}

	@RequestMapping(value = "/manageGroup", method = RequestMethod.POST)
	public String manageGroup(@ModelAttribute ParticipantsGroup group, HttpServletRequest request) {
		Event event = eventRepo.findById(group.getEvent().getEid()).get();
		String[] partId = request.getParameterMap().get("partiCipantList");
		ParticipantsGroup dbGroup = groupRepo.save(group);
		for (String id : partId) {
			Participant p = participantsRepo.findById(Long.parseLong(id)).get();
			p.setPartiCipantGroup(dbGroup);
			participantsRepo.save(p);
		}
		return "redirect:/event/group/" + event.getEid();

	}

	@GetMapping(value = "/viewGroups/{eventId}")
	public ModelAndView viewGroups(@PathVariable Long eventId) {
		Event event = eventRepo.findById(eventId).get();
		List<ParticipantsGroup> partGroup = groupRepo.findByEvent(event);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("groupList");
		modelAndView.addObject("partGroup", partGroup);
		modelAndView.addObject("eventId", eventId);

		return modelAndView;

	}

}
