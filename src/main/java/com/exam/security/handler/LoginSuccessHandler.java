package com.exam.security.handler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
  
  protected Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    
    logger.debug("call LoginSuccessHandler.onAuthenticationSuccess()");
    logger.debug("authentication = {}", authentication.getPrincipal().toString());
  
    List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
    List<GrantedAuthority> ownerRoles 
        = authorities
            .stream()
            .filter(role->"ROLE_ADMIN".equals(role.getAuthority())).collect(Collectors.toList());

    Cookie cookie = null;
    if(ownerRoles!=null && !ownerRoles.isEmpty()) {
      cookie = new Cookie("auth", "admin");
    } else {
      cookie = new Cookie("auth", "user");
    }
    
    cookie.setPath("/");
    response.addCookie(cookie);    
    response.sendRedirect("hello.do");
  }

}
