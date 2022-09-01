package com.patikadev.shoppingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.patikadev.shoppingapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "SELECT * FROM products p WHERE DATE(NOW()) < p.expiration_date OR p.expiration_date is null",
			nativeQuery = true)
	List<Product> findAllNotExpired();
	
	@Query(value = "SELECT * FROM products p WHERE DATE(NOW()) >= p.expiration_date",
			nativeQuery = true)
	List<Product> findAllExpired();
}
