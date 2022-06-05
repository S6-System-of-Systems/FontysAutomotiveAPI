package com.fontys_automotive.api.config;

import com.fontys_automotive.api.rabbit.Receiver;
import com.fontys_automotive.api.rabbit.Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue tusSendRequest() {
        return new Queue("tusSendRequest");
    }

    @Bean
    public Queue tusReceiveRequest() {
        return new Queue("tusReceiveRequest");
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}
