package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Event;
import com.revature.services.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController {

	
	@Autowired
	EventService eventService;
	
	@GetMapping
	public List<Event> getEvents( 
				@RequestParam(required = false) Integer eventTypeId,
				@RequestParam(required = false) Integer userId)  {
		
		if(eventTypeId != null) {
			return eventService.getEventsByEventTypeId(eventTypeId);
		} else if(userId != null) {
			return eventService.getEventsByUserId(userId);
		} else {
			return eventService.getEvents();
		}
	}
	
	@PostMapping
	public Event saveEvent(@Valid @RequestBody Event event) {
		return eventService.save(event);
	}
	
	@GetMapping("/eventId/{id}")
	public Event getEventById(@PathVariable int id) {
		return eventService.findById(id);
	}
	
	@GetMapping("/eventTitle/{title}")
	public List<Event> getEventsByTitle(@PathVariable String title) {
		return eventService.getEventsByTitle(title);
	}
	
	@PutMapping
	public Event updateEvent(@RequestBody Event event) {
		return eventService.update(event);
	}
	
}
