package com.patikadev.shoppingapp.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	@Column(nullable = false, length = 500)
	private String comment;
	
	@Column(nullable = false)
	private Date commentDate;
}
