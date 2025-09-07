package com.polli.gustavo.devpoc.modules.messaging.usecase;

import com.polli.gustavo.devpoc.modules.messaging.dto.MessageDTO;
import com.polli.gustavo.devpoc.modules.messaging.producers.KafkaProducer;
import com.polli.gustavo.devpoc.modules.messaging.producers.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendMessageUseCase {

    private final KafkaProducer kafkaProducer;
    private final RabbitMQProducer rabbitMQProducer;

    public void execute(MessageDTO message) {
        kafkaProducer.sendMessage(message);
        rabbitMQProducer.sendMessage(message);
    }
}