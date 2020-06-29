package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Event;
import com.revature.entities.Post;
import com.revature.repositories.PostRepository;


@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public Post findById(int id) {
		return postRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public Post update(Post post) {
		if (post.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		return save(post);
	}

	public List<Post> getPosts() {
		return postRepository.findAll();
	}
	
	public List<Post> getPostsByUserId(Integer userId) {
		return postRepository.getPostsByUserId(userId);
	}
	
	public List<Post> getPostsByEventId(Integer eventId) {
		return postRepository.getPostsByEventId(eventId);
	}

}
