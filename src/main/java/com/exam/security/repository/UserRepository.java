package com.exam.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.security.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
  public User findByUserName(String userName); 
  public User findBySocialUserId(String socialUserId); 
}
