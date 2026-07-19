package com.neha.gandalfdefender.chat.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatRequest {

    @NotBlank(message = "message must not be empty")
    private String message;

    // Which defense level to test against: 0, 1, 2, or 3 (see application.yml)
    private int defenseLevel = 0;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }
}
