package com.projecAsapcard.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.model.Model;

public class Consumer {
	  @Autowired
	    private MyRepository repository;

	    @RabbitListener(queues = "csv-stream")
	    public void receive(String json) {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Model model = objectMapper.readValue(json, Model.class);
	        repository.save(model);
	    }
	}

