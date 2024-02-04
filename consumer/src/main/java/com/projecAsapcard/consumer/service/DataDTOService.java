package com.projecAsapcard.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projecAsapcard.consumer.model.DataDTO;
import com.projecAsapcard.consumer.model.Installment;
import com.projecAsapcard.consumer.model.Person;
import com.projecAsapcard.consumer.model.Transaction;
import com.projecAsapcard.consumer.repository.TransactionRepository;



@Service
public class DataDTOService {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private InstallmentService installmentService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public DataDTO saveAllByDataDTO(DataDTO dataDTO) {
		
		Person person = personService.createPerson(dataDTO);
		Transaction transaction = transactionService.createTransaction(dataDTO);
		List<Installment> installments = installmentService.createInstallment(dataDTO);
	
		
		personService.updatePerson(person, transaction );
		transactionService.updateTransaction(transaction, person, installments);
		installmentService.updateInstallment(installments, transaction);
		
		return dataDTO;

	}
	
}