package com.patikadev.shoppingapp.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.patikadev.shoppingapp.dto.CommentCreateDto;
import com.patikadev.shoppingapp.dto.CommentDto;
import com.patikadev.shoppingapp.entity.Comment;
import com.patikadev.shoppingapp.entity.Product;
import com.patikadev.shoppingapp.entity.User;
import com.patikadev.shoppingapp.repository.CommentRepository;
import com.patikadev.shoppingapp.service.CommentService;
import com.patikadev.shoppingapp.service.ProductService;
import com.patikadev.shoppingapp.service.UserService;

@Service
public class CommentServiceImpl implements CommentService{

	private UserService userService;
	
	private ProductService productService;
	
	private CommentRepository commentRepository;
	
	private ModelMapper modelMapper;
	
	public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, UserService userService, ProductService productService) {
		this.commentRepository = commentRepository;
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.productService = productService;
	}

	@Override
	public CommentDto createComment(Long userId, Long productId, CommentCreateDto commentCreateDto) {
		User user = userService.getUserById(userId);
		Product product = productService.getProductById(productId);
		Comment comment = modelMapper.map(commentCreateDto, Comment.class);
		Date date = new Date();
		comment.setCommentDate(date);
		comment.setUser(user);
		comment.setProduct(product);
		commentRepository.save(comment);
		return modelMapper.map(comment, CommentDto.class);
	}

	@Override
	public List<CommentDto> getAllCommentByProductId(Long productId) {
		List<Comment> comments = commentRepository.findAllByProductId(productId);
		return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<CommentDto> getAllCommentByUserId(Long userId) {
		List<Comment> comments = commentRepository.findAllByUserId(userId);
		return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<CommentDto> getAllCommentByUserIdInDateRange(Long userId, Date firstDate, Date lastDate) {
		List<Comment> comments = commentRepository.findAllByUserIdAndCommentDateBetween(userId, firstDate, lastDate);
		return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<CommentDto> getAllCommentByProductIdInDateRange(Long productId, Date firstDate, Date lastDate) {
		List<Comment> comments = commentRepository.findAllByProductIdAndCommentDateBetween(productId, firstDate, lastDate);
		return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
	}

}
