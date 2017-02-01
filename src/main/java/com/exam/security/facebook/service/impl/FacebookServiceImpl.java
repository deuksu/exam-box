package com.exam.security.facebook.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestOperations;

import com.exam.security.facebook.domain.FacebookUser;
import com.exam.security.facebook.service.FacebookService;

public class FacebookServiceImpl implements FacebookService {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  
  private String facebookProfileUri;
  private RestOperations facebookRestTemplate;
  
  public FacebookServiceImpl(RestOperations facebookRestTemplate, String facebookProfileUri) {
    this.facebookRestTemplate = facebookRestTemplate;
    this.facebookProfileUri = facebookProfileUri;
  }

  @Override
  public FacebookUser findUser() {
    FacebookUser facebookUser = facebookRestTemplate.getForObject(facebookProfileUri, FacebookUser.class);
    logger.debug(facebookUser.toString());
    return facebookUser;
  }

}
