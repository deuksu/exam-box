package com.exam.security.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="com.exam.security.web.HomeController")
public class HomeController {
  private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
  
  @RequestMapping(value="/denyAnonymousUrl.do")
  @ResponseBody
  public String denyAnonymousUrl() {
    return "deny anonymous url";
  }    
  
/*  @RequestMapping(value="/accessDeniedUrl.do")
  @ResponseBody
  public String accessDeniedUrl(HttpServletRequest req) {
    return "access denied url";
  }   */ 
  
  @RequestMapping(value="/accessDeniedUrl.do")
  @ResponseBody
  public ModelAndView accessDeniedUrl() {
    ModelAndView view = new ModelAndView();
    view.setViewName("403");
    return view;
  }     
  
  @RequestMapping(value="/invalidSessionUrl.do")
  @ResponseBody
  public String invalidSessionUrl() {
    return "invalid session url";
  }      
  
  @RequestMapping(value="/")
  public String main() {
    return "redirect:/home.do";
  }
  
  @RequestMapping(value="/home.do")
  public void home() {}
  
  @RequestMapping(value="/login.do", method = RequestMethod.GET)
  public void login() {}  

  @RequestMapping(value="/hello.do")
  public void hello() {}   
  
  @RequestMapping(value="/logout.do")
  public ModelAndView logout() {
    ModelAndView view = new ModelAndView();
    view.setViewName("login");
    return view;
  }   
  
}
