package com.projecAsapcard.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecAsapcard.consumer.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
