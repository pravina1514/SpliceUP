/**
 * 
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	UserMasterRepository repo;

	@RequestMapping(value = "/welcometest")
	public String welcome(Map<String, Object> model) {

		model.put("message", "abc");
		return "templates/welcome";
	}

	@RequestMapping(value = "/save")
	public void saveEmployee() {
		List<Event> events = new ArrayList<>();
		UserMaster info = new UserMaster();

		info.setEmail("Abc1111");
		info.setPassword("def1111");
		Event e = new Event();
		e.setName("Test Event");
		e.setEventHost(info);
		events.add(e);
		info.setMyEvents(events);

		UserDetail user = new UserDetail();
		user.setGender("Tes111t11");
		user.setMobile_no(111l);
		user.setName("a111bc1");
		user.setUser(info);
		info.setUserDetail(user);

		repo.save(info);

	}
}
