package com.patikadev.shoppingapp.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	@Column(nullable = false,length = 50)
	private String name;
	
	@Column(nullable = false,length = 50)
	private String surName;
	
	@Column(nullable = false,length = 50)
	private String email;
	
	@Column(nullable = false,length = 15)
	private String phoneNumber;
	
}
