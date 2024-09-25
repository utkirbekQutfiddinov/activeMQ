package org.example.projecteop.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jms")
public class TextController {

//    private final JmsTemplate jmsTemplate;
//
//    public TextController(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }
//
//    @PostMapping
//    public void yoz(@RequestParam("que") String q, @RequestParam("message") String text) {
//        jmsTemplate.convertAndSend(q, text);
//    }
//
//
//    @GetMapping
//    public String get(@RequestParam("name") String name) throws JMSException {
//        TextMessage receive = (TextMessage) jmsTemplate.receive(name);
//
//        return receive.getText();
//    }
}
