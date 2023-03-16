package com.edunavarro.springboot.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edunavarro.springboot.h2.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
