package com.patikadev.shoppingapp.service;

import com.patikadev.shoppingapp.dto.UserDto;
import com.patikadev.shoppingapp.entity.User;

public interface UserService {

	UserDto createUser(UserDto userDto);

	User getUserById(Long id);
}
