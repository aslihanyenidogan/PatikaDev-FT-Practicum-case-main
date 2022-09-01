package com.patikadev.shoppingapp.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.patikadev.shoppingapp.dto.ProductDto;
import com.patikadev.shoppingapp.entity.Product;
import com.patikadev.shoppingapp.exception.ResourseNotFoundException;
import com.patikadev.shoppingapp.repository.ProductRepository;
import com.patikadev.shoppingapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	private ModelMapper modelMapper;
	
	public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		productRepository.save(modelMapper.map(productDto, Product.class));
		return productDto;
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Product not found with id"));
	}

	//Son kullanma Tarihi geçmiş ürünleri listeler
	@Override
	public List<ProductDto> getAllProductExpired() {
		List<Product> products = productRepository.findAllExpired();
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	//Son kullanma tarihi geçmemiş yada null olan ürünleri listeler
	@Override
	public List<ProductDto> getAllProductNotExpired() {
		List<Product> products = productRepository.findAllNotExpired();
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

}
