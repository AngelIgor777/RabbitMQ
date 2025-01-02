package com.test.rabbitmq_demo.consumer;

import com.test.rabbitmq_demo.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQConsumer {
    /**
     * Метод для обработки сообщений из RabbitMQ.
     *
     * @param message сообщение, полученное из очереди
     */
    @RabbitListener(queues = "#{rabbitMQConfig.getQueueName()}")
    public void consumeMessage(String message) {
        log.info("Consumed message: {}", message);
        // Обработка сообщения
    }

    @RabbitListener(queues = "#{rabbitMQConfig.getJsonQueueName()}")  // Используйте ваше имя очереди
    public void consumeJsonMessage(User user) {
        log.info("Consumed User message: {}", user);
    }
}
