package com.exam.security.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.security.domain.User;
import com.exam.security.repository.UserRepository;

@Service(value="com.exam.security.service.impl.SecurityUserDetailsServiceImpl")
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

  private static final Logger logger = LoggerFactory.getLogger(SecurityUserDetailsServiceImpl.class);
  
  @Autowired UserRepository userRepository;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUserName(username);
    logger.debug("user:{} = {}",username,user.toString());
    return new SecurityUserDetails(user);
  }

  
}
