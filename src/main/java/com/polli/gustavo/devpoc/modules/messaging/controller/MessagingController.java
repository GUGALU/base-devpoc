package com.polli.gustavo.devpoc.modules.messaging.controller;

import com.polli.gustavo.devpoc.modules.messaging.dto.MessageDTO;
import com.polli.gustavo.devpoc.modules.messaging.usecase.SendMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging")
@RequiredArgsConstructor
public class MessagingController {

    private final SendMessageUseCase sendMessageUseCase;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDTO message) {
        sendMessageUseCase.execute(message);
        return ResponseEntity.ok().build();
    }
}