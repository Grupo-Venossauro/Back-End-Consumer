package com.projecAsapcard.consumer.consumer;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projecAsapcard.consumer.service.ConsumeMessageService;

@Configuration
public class ConfigureRabbitMq {

    public static final String QUEUE_NAME = "csv-stream";

    @Bean
    SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory,
                                                                  MessageListenerAdapter messageListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        
        // Use setChannelTransacted para configurar o MessageConverter
        container.setChannelTransacted(true);
        
        container.setMessageListener(messageListenerAdapter);

        return container;
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(ConsumeMessageService consumeMessageService,
                                                  Jackson2JsonMessageConverter messageConverter) {
        // Configura o MessageListenerAdapter com o MessageConverter
        MessageListenerAdapter adapter = new MessageListenerAdapter(consumeMessageService, "consumeMessage");
        adapter.setMessageConverter(messageConverter);
        return adapter;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

