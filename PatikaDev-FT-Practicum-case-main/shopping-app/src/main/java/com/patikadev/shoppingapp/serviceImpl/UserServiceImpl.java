package com.patikadev.shoppingapp.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.patikadev.shoppingapp.dto.UserDto;
import com.patikadev.shoppingapp.entity.User;
import com.patikadev.shoppingapp.exception.ResourseNotFoundException;
import com.patikadev.shoppingapp.repository.UserRepository;
import com.patikadev.shoppingapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public UserDto createUser(UserDto userDto) {
		userRepository.save(modelMapper.map(userDto, User.class));
		return userDto;
	}
	
	public User getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User not found with id"));
		return user;
	}
}
