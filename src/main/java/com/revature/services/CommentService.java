package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Comment;
import com.revature.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	public Comment findById(int id) {
		return commentRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public Comment update(Comment comment) {
		if (comment.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		return save(comment);
	}

	public List<Comment> getComments() {
		return commentRepository.findAll();
	}
	
	public List<Comment> getCommentsByUserId(Integer userId) {
		return commentRepository.getCommentsByUserId(userId);
	}
	
	public List<Comment> getCommentsByPostId(Integer postId) {
		return commentRepository.getCommentsByPostId(postId);
	}

}
