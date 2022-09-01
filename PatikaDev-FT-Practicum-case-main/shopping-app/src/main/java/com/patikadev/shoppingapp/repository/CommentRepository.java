package com.patikadev.shoppingapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patikadev.shoppingapp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findAllByProductId(long productId);
	
	List<Comment> findAllByUserId(long userId);
	
	List<Comment> findAllByUserIdAndCommentDateBetween(Long userId, Date firstDate, Date lastDate);
	
	List<Comment> findAllByProductIdAndCommentDateBetween(Long productId, Date firstDate, Date lastDate);
}
