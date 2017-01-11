package com.exam.box.standalone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.box.standalone.domain.Book;
import com.exam.box.standalone.repository.BookRepository;
import com.exam.box.standalone.service.StdService;

@Service(value="com.exam.box.standalone.service.impl.StdServiceImpl")
public class StdServiceImpl implements StdService {

  @Autowired BookRepository bookRepository;
  
  @Override
  public List<Book> findAll() throws Exception {
    return bookRepository.findAll();
  }

  
}
