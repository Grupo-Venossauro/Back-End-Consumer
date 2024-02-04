package com.projecAsapcard.consumer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projecAsapcard.consumer.model.DataDTO;
import com.projecAsapcard.consumer.model.Person;
import com.projecAsapcard.consumer.model.Transaction;
import com.projecAsapcard.consumer.repository.PersonRepository;

public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(DataDTO dataDTO) {
		Person person = new Person();
		
		person.setId(dataDTO.getId_person());
		person.setName(dataDTO.getNome());
		person.setAge(dataDTO.getIdade());
		
		if(!personRepository.existsById(dataDTO.getId_person())) {
			personRepository.save(person);
		}else {
			person = personRepository.getById(person.getId());
		}

		return person;
	}
	
	
	public Optional<Person> updatePerson(Person person, Transaction transaction){
		
		
		if(personRepository.existsById(person.getId())) {
			
			if(person.getTransactions() != null) {
				person.getTransactions().add(transaction);
			} else {
				List<Transaction> transactions = new ArrayList<Transaction>();
				transactions.add(transaction);
				person.setTransactions(transactions);
			}
			
			personRepository.save(person);
			return Optional.of(person);
		}

		return null; 
		
	}
	

}
