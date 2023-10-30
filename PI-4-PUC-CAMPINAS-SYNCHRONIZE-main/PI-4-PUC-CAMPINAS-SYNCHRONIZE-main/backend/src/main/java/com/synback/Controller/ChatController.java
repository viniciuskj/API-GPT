package com.synback.Controller;

import com.synback.apiGPT.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService; // supondo que você já tenha criado o serviço ChatService

    @PostMapping("/ask")
    public ResponseEntity<String> askGPT(@RequestBody String question) {
        try {
            String response = chatService.chatGPT(question);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao comunicar com o ChatGPT");
        }
    }
}
