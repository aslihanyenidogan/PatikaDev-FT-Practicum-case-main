package com.patikadev.shoppingapp.service;

import java.util.List;

import com.patikadev.shoppingapp.dto.ProductDto;
import com.patikadev.shoppingapp.entity.Product;

public interface ProductService {

	ProductDto createProduct(ProductDto productDto);
	
	Product getProductById(Long id);

	List<ProductDto> getAllProductExpired();

	List<ProductDto> getAllProductNotExpired();

}
