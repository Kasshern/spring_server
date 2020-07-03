package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.Event;
import com.revature.entities.Views;
import com.revature.services.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
			RequestMethod.PATCH, RequestMethod.POST},
allowedHeaders = {"Content-Type"})
public class EventController {

	
	@Autowired
	EventService eventService;
	
	//Externals
	
	@JsonView(Views.External.class)
	@GetMapping("external")
	public List<Event> getEvents( 
				@RequestParam(required = false) Integer eventTypeId,
				@RequestParam(required = false) Integer hostId)  {
		
		if(eventTypeId != null) {
			return eventService.getEventsByEventTypeId(eventTypeId);
		} else if(hostId != null) {
			return eventService.getEventsByUserId(hostId);
		} else {
			return eventService.getEvents();
		}
	}
	
	@JsonView(Views.External.class)
	@PostMapping("external")
	public Event saveEvent(@Valid @RequestBody Event event) {
		return eventService.save(event);
	}
	
	@JsonView(Views.External.class)
	@GetMapping("external/eventId/{id}")
	public Event getEventById(@PathVariable int id) {
		return eventService.findById(id);
	}
	
	@JsonView(Views.External.class)
	@GetMapping("external/eventTitle/{title}")
	public List<Event> getEventsByTitle(@PathVariable String title) {
		return eventService.getEventsByTitle(title);
	}
	
	@JsonView(Views.External.class)
	@GetMapping("external/eventTypeId/{eventTypeId}")
	public List<Event> getEventsByEventTypeId(@PathVariable Integer eventTypeId) {
		return eventService.getEventsByEventTypeId(eventTypeId);
	}
	
	@JsonView(Views.External.class)
	@PutMapping("external")
	public Event updateEvent(@RequestBody Event event) {
		return eventService.update(event);
	}
	
	
	//Internals 
	
	@JsonView(Views.Internal.class)
	@GetMapping("internal")
	public List<Event> getEvents2( 
				@RequestParam(required = false) Integer eventTypeId,
				@RequestParam(required = false) Integer hostId)  {
		
		if(eventTypeId != null) {
			return eventService.getEventsByEventTypeId(eventTypeId);
		} else if(hostId != null) {
			return eventService.getEventsByUserId(hostId);
		} else {
			return eventService.getEvents();
		}
	}
	
	@JsonView(Views.Internal.class)
	@PostMapping("internal")
	public Event saveEvent2(@Valid @RequestBody Event event) {
		return eventService.save(event);
	}
	
	@JsonView(Views.Internal.class)
	@GetMapping("internal/eventId/{id}")
	public Event getEventById2(@PathVariable int id) {
		return eventService.findById(id);
	}
	
	@JsonView(Views.Internal.class)
	@GetMapping("internal/eventTitle/{title}")
	public List<Event> getEventsByTitle2(@PathVariable String title) {
		return eventService.getEventsByTitle(title);
	}
	
	@JsonView(Views.Internal.class)
	@GetMapping("internal/eventTypeId/{eventTypeId}")
	public List<Event> getEventsByEventTypeId2(@PathVariable Integer eventTypeId) {
		return eventService.getEventsByEventTypeId(eventTypeId);
	}
	
	@JsonView(Views.Internal.class)
	@PutMapping("internal")
	public Event updateEvent2(@RequestBody Event event) {
		return eventService.update(event);
	}
	
	//Secrets 
	
	@JsonView(Views.Secret.class)
	@GetMapping("secret")
	public List<Event> getEvents3( 
				@RequestParam(required = false) Integer eventTypeId,
				@RequestParam(required = false) Integer hostId)  {
		
		if(eventTypeId != null) {
			return eventService.getEventsByEventTypeId(eventTypeId);
		} else if(hostId != null) {
			return eventService.getEventsByUserId(hostId);
		} else {
			return eventService.getEvents();
		}
	}
	
	@JsonView(Views.Secret.class)
	@PostMapping("secret")
	public Event saveEvent3(@Valid @RequestBody Event event) {
		return eventService.save(event);
	}
	
	@JsonView(Views.Secret.class)
	@GetMapping("secret/eventId/{id}")
	public Event getEventById3(@PathVariable int id) {
		return eventService.findById(id);
	}
	
	@JsonView(Views.Secret.class)
	@GetMapping("secret/eventTitle/{title}")
	public List<Event> getEventsByTitle3(@PathVariable String title) {
		return eventService.getEventsByTitle(title);
	}
	
	@JsonView(Views.Secret.class)
	@GetMapping("secret/eventTypeId/{eventTypeId}")
	public List<Event> getEventsByEventTypeId3(@PathVariable Integer eventTypeId) {
		return eventService.getEventsByEventTypeId(eventTypeId);
	}
	
	@JsonView(Views.Secret.class)
	@PutMapping("secret")
	public Event updateEvent3(@RequestBody Event event) {
		return eventService.update(event);
	}
	
}
