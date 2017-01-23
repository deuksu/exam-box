package com.exam.security.service;

import com.exam.security.service.impl.SecurityUserDetails;

public interface UserService {
  public SecurityUserDetails insertUser(final SecurityUserDetails param) throws Exception;
}
