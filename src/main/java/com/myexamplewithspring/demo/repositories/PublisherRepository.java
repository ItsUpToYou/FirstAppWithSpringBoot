package com.myexamplewithspring.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.myexamplewithspring.demo.domain.Publisher;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {


}
