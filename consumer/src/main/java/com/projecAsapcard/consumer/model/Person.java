package com.projecAsapcard.consumer.model;

import java.util.List;

import org.hibernate.validator.constraints.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transaction;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_person")
public class Person {
	
	@UUID
	private String id;

	@NotNull(message = "O Atributo Nome é Obrigatório!")
	private String name;

	private Integer age;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("person")
	private List<Transaction> transaction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}


	

	}