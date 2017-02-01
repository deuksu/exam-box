package com.exam.security.facebook.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.exam.security.facebook.FacebookAuthenticationToken;


public class FacebookAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
  
  private String defaultFilterProcessesUrl;
  
  public FacebookAuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
    super(defaultFilterProcessesUrl);
  }

  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
      FacebookAuthenticationToken authRequest = new FacebookAuthenticationToken("facebook", null);
      SecurityContextHolder.getContext().setAuthentication(authRequest);
      return this.getAuthenticationManager().authenticate(authRequest);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    // TODO Auto-generated method stub
    super.successfulAuthentication(request, response, chain, authResult);
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException failed) throws IOException, ServletException {
    // TODO Auto-generated method stub
    super.unsuccessfulAuthentication(request, response, failed);
  }
  
  
}
