package com.activemq1.services;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JMSProducer {
//    @Autowired
//    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("publish1/{msg}")
    public String publish(@PathVariable("msg") final String msg) {
        jmsTemplate.convertAndSend("simple-jms-queue1", msg);
        return "Your message <b>" + msg + "</b> published successfully";
    }

    @GetMapping("publish2/{msg}")
    public String publish2(@PathVariable("msg") final String msg) {
        jmsTemplate.convertAndSend("simple-jms-queue2", msg);
        return "Your message <b>" + msg + "</b> published successfully";
    }

    @GetMapping("publish-topic/{msg}")
    public String publishTopic(@PathVariable("msg") final String msg) {
        jmsTemplate.convertAndSend(new ActiveMQTopic("topic"), msg);
        return "Your message <b>" + msg + "</b> published successfully";
    }
}
