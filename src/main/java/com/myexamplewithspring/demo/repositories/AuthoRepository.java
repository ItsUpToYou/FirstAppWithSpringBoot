package com.myexamplewithspring.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.myexamplewithspring.demo.domain.Author;

public interface AuthoRepository extends CrudRepository<Author,Long> {

}
