package com.exam.security.handler;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityPasswordEncoder implements PasswordEncoder {
  
  private BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
  
  @Override
  public String encode(CharSequence rawPassword) {
    // TODO Auto-generated method stub
    return bcryptPasswordEncoder.encode(rawPassword);
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    // TODO Auto-generated method stub
    return bcryptPasswordEncoder.matches(rawPassword, encodedPassword);
  }

}
