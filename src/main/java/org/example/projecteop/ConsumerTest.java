package org.example.projecteop;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.example.projecteop.config.ActiveMqConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class ConsumerTest {
    public static void main(String[] args) throws JMSException {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ActiveMqConfig.class);


        JmsTemplate jms = ctx.getBean(JmsTemplate.class);

//        jms.convertAndSend("pdp","salom pdp talabalari!");

        TextMessage receive = (TextMessage) jms.receive("pdp");

        System.out.println("receive.getText() = " + receive.getText());


    }
}
