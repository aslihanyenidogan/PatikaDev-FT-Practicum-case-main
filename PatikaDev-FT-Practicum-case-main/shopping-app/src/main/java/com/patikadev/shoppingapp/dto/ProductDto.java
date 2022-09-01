package com.patikadev.shoppingapp.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double price;
	
	private Date expirationDate;
}
