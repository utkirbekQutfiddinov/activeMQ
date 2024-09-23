package org.example.projecteop;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

public class ConsumerTest {
    public static void main(String[] args) throws JMSException {


        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection con = connectionFactory.createConnection();

        con.start();

        Session session = con.createSession();
//        MessageConsumer consumer = session.createConsumer(new ActiveMQQueue("pdp"));
//
//        TextMessage receive =(TextMessage) consumer.receive();
//
//        System.out.println("receive.getText() = " + receive.getText());

        Queue queue = session.createQueue("pdp");
        MessageProducer producer = session.createProducer(queue);

        TextMessage t1=new ActiveMQTextMessage();
        t1.setText("Hello PDP");
        producer.send(t1);
    }
}
