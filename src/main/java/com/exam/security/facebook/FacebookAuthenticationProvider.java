package com.exam.security.facebook;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

import com.exam.security.facebook.domain.FacebookUser;
import com.exam.security.facebook.service.FacebookService;

public class FacebookAuthenticationProvider implements AuthenticationProvider {
  private FacebookService facebookService;
  private String facebookRole;
  
  public FacebookAuthenticationProvider(FacebookService facebookService, String facebookRole) {
    this.facebookService = facebookService;
    this.facebookRole = facebookRole;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    Assert.isInstanceOf(FacebookAuthenticationToken.class, authentication, "Only FacebookAuthenticationProvider is supported");
    Collection<GrantedAuthority> authorities = generateAuthorities();
    FacebookUser facebookUser = facebookService.findUser();
    FacebookAuthenticationToken token = new FacebookAuthenticationToken(facebookUser.getName(), null, authorities);
    token.setDetails(facebookUser);
    return token;
  }
  
  protected Collection<GrantedAuthority> generateAuthorities() {
    Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(facebookRole));
    return authorities;
  }  

  @Override
  public boolean supports(Class<?> authentication) {
    return (FacebookAuthenticationToken.class.isAssignableFrom(authentication));
  }

}