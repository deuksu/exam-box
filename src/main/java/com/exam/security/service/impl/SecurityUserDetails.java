package com.exam.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.exam.security.domain.User;
import com.exam.security.domain.UserRole;

public class SecurityUserDetails extends org.springframework.security.core.userdetails.User {
  private static final long serialVersionUID = 1L;
 
  private User user;
  
  @Autowired 
  public SecurityUserDetails(User user) {
    super(user.getUserName(), user.getPassword(), authorities(user.getRoles()));
    this.user = user;
  }
  
  public static Collection<? extends GrantedAuthority> authorities(Collection<UserRole> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    if(roles!=null&&!roles.isEmpty()) {
      roles.forEach(role->{authorities.add(new SimpleGrantedAuthority(role.getRole()));});
    }
    return authorities;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
  
}
