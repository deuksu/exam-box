package com.exam.security.handler;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityPasswordEncoderTest {

  @Test
  public void test() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encoderStr = encoder.encode("abc");
    System.out.println("password = " + encoderStr);
    System.out.format("password = %s\n\n", encoderStr);
    System.out.format("password = %s\n\n", encoder.matches("abc", encoderStr));
    
  }

}
