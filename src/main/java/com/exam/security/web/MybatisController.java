package com.exam.security.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.security.domain.User;
import com.exam.security.mybatis.mapper.UserMapper;

@RestController(value="com.exam.security.web.MybatisController")
public class MybatisController {
  
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  
  
  @Autowired
  UserMapper userMapper;
  
  @RequestMapping(value = "/mybatis/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> findAll() throws Exception {
    ResponseEntity<List<User>> entities = new ResponseEntity<List<User>>(userMapper.findAll(), HttpStatus.OK);
    logger.debug(entities.toString());     
    return entities;
  }
  
//  , consumes = { MediaType.APPLICATION_XML_VALUE }
  @RequestMapping(value = "/mybatis/findAll2", method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_XML_VALUE })
  public User findAll2(@RequestParam(name="userId", required=true) Long userId) throws Exception {
    return userMapper.findByUserId(userId);
  }  
}
