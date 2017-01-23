package com.exam.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.security.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
  public List<UserRole> findRoleByUserId(String userId);
}
