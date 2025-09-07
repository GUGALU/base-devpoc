package com.polli.gustavo.devpoc.modules.messaging.producers;

import com.polli.gustavo.devpoc.modules.messaging.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;

    public void sendMessage(MessageDTO message) {
        kafkaTemplate.send(topicName, message);
    }
}