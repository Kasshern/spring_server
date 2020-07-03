package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Event;
import com.revature.entities.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private EventService eventService;

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findById(int id) {
		return userRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
        User newUser = findById(user.getId());
        System.out.println(newUser);
        newUser.getEvents()
                .addAll(user
                        .getEvents()
                        .stream()
                        .map(e -> {
                            Event ee = eventService.findById(e.getId());
                            ee.getUsers().add(newUser);
                            return ee;
                        }).collect(Collectors.toList()));
        return userRepository.save(newUser);
    }
}
