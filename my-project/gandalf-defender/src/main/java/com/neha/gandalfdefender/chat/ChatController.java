package com.neha.gandalfdefender.chat;

import com.neha.gandalfdefender.chat.dto.ChatRequest;
import com.neha.gandalfdefender.chat.dto.ChatResponse;
import com.neha.gandalfdefender.chat.dto.GuessRequest;
import com.neha.gandalfdefender.chat.dto.GuessResponse;
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

    // Level 4: this endpoint is completely separate from the AI chat path.
    // It never touches Ollama - just a direct, deterministic string comparison
    // in plain Java. This is what "the model never knows the secret" means in
    // practice: the ONLY way to confirm a password is through this endpoint,
    // not through anything the chatbot says.
    @PostMapping("/guess")
    public GuessResponse guess(@Valid @RequestBody GuessRequest request) {
        boolean correct = chatService.checkPasswordGuess(request.getGuess());
        return new GuessResponse(correct);
    }
}
