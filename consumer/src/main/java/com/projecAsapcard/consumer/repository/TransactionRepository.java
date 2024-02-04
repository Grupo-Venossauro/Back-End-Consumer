package com.projecAsapcard.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecAsapcard.consumer.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
