package com.fontys_automotive.api.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue tusReceiveRequest;

    public void send(String message) {
        template.convertAndSend(tusReceiveRequest.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
