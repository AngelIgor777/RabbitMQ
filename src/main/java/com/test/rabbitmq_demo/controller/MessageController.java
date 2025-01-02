package com.test.rabbitmq_demo.controller;

import com.test.rabbitmq_demo.dto.User;
import com.test.rabbitmq_demo.producer.RabbitMQJsonProducer;
import com.test.rabbitmq_demo.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    /**
     * Endpoint для отправки сообщения в RabbitMQ.
     *
     * @param message сообщение для отправки
     * @return HTTP-ответ с подтверждением отправки
     */
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        rabbitMQProducer.send(message);
        return ResponseEntity.ok("Message sent: " + message);
    }


    @PostMapping("/users")
    public ResponseEntity<String> sendJsonMessage(@RequestBody  User user) {
        rabbitMQJsonProducer.send(user);
        return ResponseEntity.ok().build();
    }

}