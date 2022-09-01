package com.patikadev.shoppingapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patikadev.shoppingapp.dto.CommentCreateDto;
import com.patikadev.shoppingapp.dto.CommentDto;
import com.patikadev.shoppingapp.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping("/{userId}/{productId}")
	public ResponseEntity<CommentDto> createComment(@PathVariable long userId,
													@PathVariable Long productId,
													@RequestBody CommentCreateDto commentCreateDto){
		return new ResponseEntity<>(commentService.createComment(userId, productId, commentCreateDto),HttpStatus.CREATED);
	}
	
	//Bir ürüne ait yorumları listeler
	@GetMapping("/byProductId/{productId}")
	public List<CommentDto> getAllCommentByProductId(@PathVariable Long productId){
		return commentService.getAllCommentByProductId(productId);
	}
	
	//Bir kullanıcının yapmış olduğu yorumları listeler
	@GetMapping("/byUserId/{userId}")
	public List<CommentDto> getAllCommentByUserId(@PathVariable Long userId){
		return commentService.getAllCommentByUserId(userId);
	}
	
	//Bir kullanıcının belirli tarihler arasında yapmış olduğu yorumları getirir
	@GetMapping("/byUserIdInDateRange/{userId}")
	public List<CommentDto> getAllCommentByUserIdInDateRange(@PathVariable Long userId, 
															 @RequestParam(value = "firstDate") Date firstDate,
															 @RequestParam(value = "lastDate") Date lastDate){
		return commentService.getAllCommentByUserIdInDateRange(userId,firstDate,lastDate);
	}
	
	//Verilen tarih aralıklarında belirli bir ürüne yapılmış yorumları getirir
	@GetMapping("/byProductIdInDateRange/{productId}")
	public List<CommentDto> getAllCommentByProductIdInDateRange(@PathVariable Long productId, 
															 @RequestParam(value = "firstDate") Date firstDate,
															 @RequestParam(value = "lastDate") Date lastDate){
		return commentService.getAllCommentByProductIdInDateRange(productId,firstDate,lastDate);
	}
}
