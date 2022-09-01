package com.patikadev.shoppingapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patikadev.shoppingapp.dto.ProductDto;
import com.patikadev.shoppingapp.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.createProduct(productDto),HttpStatus.CREATED);
	}
	@GetMapping("/expired")
	public List<ProductDto> getAllProductExpired(){
		return productService.getAllProductExpired();
	}
	@GetMapping("/notExpired")
	public List<ProductDto> getAllProductNotExpired(){
		return productService.getAllProductNotExpired();
	}
}
