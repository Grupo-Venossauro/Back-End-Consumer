package com.projecAsapcard.consumer.model;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "tb_installment")
public class Installment {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO) 
	private String id;
	
	private Integer installment_number;
	
//	@ManyToOne
//	@JsonIgnoreProperties("installment")
	private Transaction transaction;
	
	private Double value;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getInstallment_number() {
		return installment_number;
	}

	public void setInstallment_number(Integer installment_number) {
		this.installment_number = installment_number;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	


}