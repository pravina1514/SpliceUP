/**
 * 
 */
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventRepository eventRepo;
	
	@Override
	public List<Event> getEventList(){
		return eventRepo.findAll();
	}
	

}
