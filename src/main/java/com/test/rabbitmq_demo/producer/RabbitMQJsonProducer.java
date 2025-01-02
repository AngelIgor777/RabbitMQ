package com.test.rabbitmq_demo.producer;

import com.test.rabbitmq_demo.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json.RoutingKey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void send(User user) {
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
        log.info("send: {}",user);
    }
}
