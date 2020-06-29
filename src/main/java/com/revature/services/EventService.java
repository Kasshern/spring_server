package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Event;
import com.revature.repositories.EventRepository;


@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;

	public Event save(Event event) {
		return eventRepository.save(event);
	}

	public Event findById(int id) {
		return eventRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public Event update(Event event) {
		if (event.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		return save(event);
	}

	public List<Event> getEvents() {
		return eventRepository.findAll();
	}
	
	public List<Event> getEventsByEventTypeId(Integer eventTypeId) {
		return eventRepository.getEventsByEventTypeId(eventTypeId);
	}
	
	public List<Event> getEventsByUserId(Integer userId) {
		return eventRepository.getEventsByUserId(userId);
	}

	public List<Event> getEventsByTitle(String title) {
		return eventRepository.getEventsByTitle(title);
	}
}
