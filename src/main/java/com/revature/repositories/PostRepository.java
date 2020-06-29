package com.revature.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Event;
import com.revature.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> getPostsByUserId(int userId);

	List<Post> getPostsByEventId(int eventId);

}
