package com.patikadev.shoppingapp.service;

import java.util.Date;
import java.util.List;

import com.patikadev.shoppingapp.dto.CommentCreateDto;
import com.patikadev.shoppingapp.dto.CommentDto;

public interface CommentService {

	CommentDto createComment(Long userId, Long productId, CommentCreateDto commentCreateDto);

	List<CommentDto> getAllCommentByProductId(Long productId);

	List<CommentDto> getAllCommentByUserId(Long userId);

	List<CommentDto> getAllCommentByUserIdInDateRange(Long userId, Date firstDate, Date lastDate);

	List<CommentDto> getAllCommentByProductIdInDateRange(Long productId, Date firstDate, Date lastDate);

}
