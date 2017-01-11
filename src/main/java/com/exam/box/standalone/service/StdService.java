package com.exam.box.standalone.service;

import java.util.List;

import com.exam.box.standalone.domain.Book;

public interface StdService {
  
  public List<Book> findAll() throws Exception;
}
