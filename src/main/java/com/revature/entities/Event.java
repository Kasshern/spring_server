package com.revature.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.External.class)
	private int id;
	
	@JsonView(Views.External.class)
	private String title;
	@JsonView(Views.External.class)
	private String image;
	@JsonView(Views.External.class)
	private double price;
	
	@JsonView(Views.External.class)
	@Column(name = "start_time")
	private LocalDate startTime;
	
	@JsonView(Views.External.class)
	@Column(name = "max_people")
	private int maxPeople;
	
	@JsonView(Views.External.class)
	private String description;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_type_id")
	@JsonView(Views.External.class)
	private EventType eventType;
	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "event_location_id")
//	private EventLocation eventLocation;
//	
//	// The many side loads lazily by default
//	@OneToMany(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "event_id")
//	private List<Post> posts;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "host_id")
	@JsonView(Views.Internal.class)
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name="user_events", joinColumns = { @JoinColumn(name="event_id") },
							inverseJoinColumns = { @JoinColumn(name="attend_id") })
	@JsonView(Views.Secret.class)
	private List<User> users = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
