package com.exam.box.standalone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.box.standalone.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
