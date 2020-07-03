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

import com.revature.entities.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
			RequestMethod.PATCH, RequestMethod.POST},
allowedHeaders = {"Content-Type"})
public class PostController {

	
	@Autowired
	PostService postService;
	
	@GetMapping
	public List<Post> getPosts(
			@RequestParam(required = false) Integer userId,
			@RequestParam(required = false) Integer eventId)  {
		
		if(eventId != null) {
			return postService.getPostsByEventId(eventId);
		} else if(userId != null) {
			return postService.getPostsByUserId(userId);
		} else {
			return postService.getPosts();
		}
	}
	
	@PostMapping
	public Post savePost(@Valid @RequestBody Post post) {
		return postService.save(post);
	}
	
	@GetMapping("/{id}")
	public Post getPostById(@PathVariable int id) {
		return postService.findById(id);
	}
	
	@PutMapping
	public Post updatePost(@RequestBody Post post) {
		return postService.update(post);
	}
}
