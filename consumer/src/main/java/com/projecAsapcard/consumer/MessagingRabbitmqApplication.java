package com.projecAsapcard.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projecAsapcard.consumer.model.DataDTO;

@SpringBootApplication
public class MessagingRabbitmqApplication {

    private static final Logger log = LoggerFactory.getLogger(MessagingRabbitmqApplication.class);
    static final String queueName = "csv-stream";

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    // Adicione o bean MessageConverter aqui
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = queueName)
    public void receiveMessage(DataDTO dataDTO) { // Mude o parâmetro para DataDTO
        log.info("Consumed Message: {}", dataDTO);
        // Processe os dados do DTO aqui
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagingRabbitmqApplication.class, args);
    }
}
