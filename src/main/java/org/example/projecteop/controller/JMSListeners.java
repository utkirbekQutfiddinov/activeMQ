package org.example.projecteop.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class JMSListeners {

//    @Async
//    @JmsListener(destination = "admin")
//    public void askjhbdashb(String message) {
//        System.out.println("message: " + message + " " + Thread.currentThread().getName());
//    }
//
//    @Async
//    @JmsListener(destination = "admin")
//    public void asasasa(String message) {
//        System.out.println("Received a new message: " + message + " " + Thread.currentThread().getName());
//    }

}
