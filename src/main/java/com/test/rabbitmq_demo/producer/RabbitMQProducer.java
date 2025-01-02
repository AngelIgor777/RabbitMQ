package com.test.rabbitmq_demo.producer;

import com.test.rabbitmq_demo.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQProducer {

    private final RabbitTemplate template;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public void send(String message) {
        log.info("send message: {}", message);
        template.convertAndSend(exchangeName, routingKey, message);
    }
}
