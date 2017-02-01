package com.exam.security.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.exam.security.domain.User;

public interface UserMapper {
  public List<User> findAll() throws DataAccessException;
  public User findByUserId(Long userId) throws DataAccessException;
}
