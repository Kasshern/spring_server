package com.revature.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	
	List<Event> getEventsByEventTypeId(int eventTypeId);
	
	List<Event> getEventsByTitle(String title);

	List<Event> getEventsByUserId(int userId);
	
}
