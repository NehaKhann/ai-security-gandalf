package com.neha.gandalfdefender.chat;

import com.neha.gandalfdefender.chat.dto.ChatRequest;
import com.neha.gandalfdefender.chat.dto.ChatResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        return chatService.handleChat(request);
    }
}
