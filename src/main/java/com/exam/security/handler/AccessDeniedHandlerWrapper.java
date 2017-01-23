package com.exam.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AccessDeniedHandlerWrapper implements AccessDeniedHandler {
  
  protected Logger logger = LoggerFactory.getLogger(AccessDeniedHandlerWrapper.class);
  
  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException, ServletException {
    
    request.setAttribute("accessDeniedException", accessDeniedException);
    response.sendRedirect("/accessDeniedUrl.do");
  }

}
