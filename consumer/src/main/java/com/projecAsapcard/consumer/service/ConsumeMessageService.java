package com.projecAsapcard.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class ConsumeMessageService {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumeMessageService.class);

    public void consumeMessage(String messageBody) {
        log.info("Consumed Message: " + messageBody);
    }
}
