package com.activemq2.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

@Component
@Slf4j
public class JmsConsumer {

    @JmsListener(destination = "simple-jms-queue2")
    public void secondListener(String msg) {
        System.out.println("Received Message : " + msg);
    }

    @JmsListener(destination = "topic", containerFactory = "topicListenerFactory")
    public void receiveTopicMessage(@Payload String payload,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {

        System.out.println("received <" + payload + ">");
    }


}
