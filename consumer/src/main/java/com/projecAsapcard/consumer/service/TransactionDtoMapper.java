package com.projecAsapcard.consumer.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.projecAsapcard.consumer.model.Transaction;

import com.projecAsapcard.consumer.model.DataDTO;
public class TransactionDtoMapper {

    public static Transaction map(DataDTO dataDTO) {
        Transaction transaction = new Transaction();
        transaction.setId(dataDTO.getIdTransaction());

        try {
            transaction.setTransaction_date(LocalDateTime.parse(dataDTO.getDate()));
        } catch (Exception e) {
            System.err.println("Erro ao converter a data: " + e.getMessage());
        }

        transaction.setAmount(BigDecimal.valueOf(dataDTO.getAmount()));
        return transaction;
    }
}