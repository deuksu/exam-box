package com.exam.security.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.security.domain.User;
import com.exam.security.domain.UserRole;
import com.exam.security.repository.UserRepository;
import com.exam.security.repository.UserRoleRepository;

@RestController(value="com.exam.security.web.WebController")
public class WebController {
  
  @Autowired UserRepository userRepository;
  @Autowired UserRoleRepository userRoleRepository;
  
  @RequestMapping(value="/user/hello.do")
  public String userHello() { 
    return "user context";
  }
  
  @RequestMapping(value="/user/findAll.do")
  public List<User> findAllOfUser() { 
    return userRepository.findAll();
  }
  
  @RequestMapping(value="/user/role/findAll.do")
  public List<UserRole> findAllOfUserRole() { 
    return userRoleRepository.findAll();
  }  
}
