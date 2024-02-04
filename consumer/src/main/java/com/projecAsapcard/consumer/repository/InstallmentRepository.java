package com.projecAsapcard.consumer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecAsapcard.consumer.model.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, UUID> {

	
	
}
