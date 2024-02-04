package com.projecAsapcard.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MessagingRabbitmqApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MessagingRabbitmqApplication.class);
    static final String queueName = "csv-stream"; 

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @RabbitListener(queues = queueName)
    public void receiveMessage(String messageBody) {
        log.info("Consumed Message: {}", messageBody);
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagingRabbitmqApplication.class, args);
    }
}
