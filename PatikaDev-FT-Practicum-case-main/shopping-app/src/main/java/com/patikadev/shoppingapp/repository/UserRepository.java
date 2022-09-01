package com.patikadev.shoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patikadev.shoppingapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
