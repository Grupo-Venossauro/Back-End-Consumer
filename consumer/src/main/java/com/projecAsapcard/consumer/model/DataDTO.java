package com.projecAsapcard.consumer.model;


import lombok.Data;

@Data
public class DataDTO {
    private String idTransaction;
    private String date;
    private String idPerson;
    private String nome;
    private Short idade;
    private Double amount;
    private Long qtdInstallment;
	public String getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Short getIdade() {
		return idade;
	}
	public void setIdade(Short idade) {
		this.idade = idade;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getQtdInstallment() {
		return qtdInstallment;
	}
	public void setQtdInstallment(Long qtdInstallment) {
		this.qtdInstallment = qtdInstallment;
	}
    
}

