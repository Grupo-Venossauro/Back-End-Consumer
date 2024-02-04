package com.projecAsapcard.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projecAsapcard.consumer.model.DataDTO;
import com.projecAsapcard.consumer.model.Installment;
import com.projecAsapcard.consumer.model.Person;
import com.projecAsapcard.consumer.model.Transaction;
import com.projecAsapcard.consumer.repository.PersonRepository;
import com.projecAsapcard.consumer.repository.TransactionRepository;

public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private PersonRepository personRepository;
	

	public Transaction createTransaction(DataDTO dataDTO) {
		

		Transaction transaction = new Transaction();
		
		transaction.setId(dataDTO.getId_transaction());	
		transaction.setTransaction_date(dataDTO.getDate());
		transaction.setAmount(dataDTO.getAmount());
		
			if(!transactionRepository.existsById(dataDTO.getId_transaction())) {
				transactionRepository.save(transaction);
			}

		return transaction;
	}
	
	
	public Transaction updateTransaction(Transaction transaction,Person person, List<Installment> installments){
		
		
		if(personRepository.existsById(person.getId())) {
			transaction.setPerson(person);
		}		
		
		transaction.setInstallments(installments);
		
		transactionRepository.save(transaction);
		
		return transaction;
	}

}
