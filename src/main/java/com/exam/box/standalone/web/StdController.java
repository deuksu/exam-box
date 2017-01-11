package com.exam.box.standalone.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="com.exam.box.standalone.web.StdIndexController")
public class StdController {

  @RequestMapping(value="/index.htm")
  public ModelAndView indexPage() {
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }
  
}
