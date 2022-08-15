package com.myexamplewithspring.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.myexamplewithspring.demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
