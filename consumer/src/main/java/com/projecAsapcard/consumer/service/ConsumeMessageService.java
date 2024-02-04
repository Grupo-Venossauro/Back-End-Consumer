package com.projecAsapcard.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.projecAsapcard.consumer.model.DataDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumeMessageService {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumeMessageService.class);

	public void consumeMessage(DataDTO dataDTO) {
	    log.info("Consumed Message: {}", dataDTO);

	}
}