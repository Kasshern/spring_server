package com.revature.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Comment;
import com.revature.entities.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> getCommentsByUserId(int userId);

	List<Comment> getCommentsByPostId(int postId);

}
