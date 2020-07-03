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

import com.revature.entities.Comment;
import com.revature.services.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
			RequestMethod.PATCH, RequestMethod.POST},
allowedHeaders = {"Content-Type"})
public class CommentController {

	@Autowired
	CommentService commentService;

	@GetMapping
	public List<Comment> getComments( 
				@RequestParam(required = false) Integer userId,
				@RequestParam(required = false) Integer postId) {

		if (postId != null) {
			return commentService.getCommentsByPostId(postId);
		} else if (userId != null) {
			return commentService.getCommentsByUserId(userId);
		} else {
			return commentService.getComments();
		}
	}

	@PostMapping
	public Comment saveComment(@Valid @RequestBody Comment comment) {
		return commentService.save(comment);
	}

	@GetMapping("/{id}")
	public Comment getCommentById(@PathVariable int id) {
		return commentService.findById(id);
	}

	@PutMapping
	public Comment updateComment(@RequestBody Comment comment) {
		return commentService.update(comment);
	}
}
