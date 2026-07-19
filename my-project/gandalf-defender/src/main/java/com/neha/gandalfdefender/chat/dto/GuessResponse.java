package com.neha.gandalfdefender.chat.dto;

public class GuessResponse {

    private boolean correct;

    public GuessResponse(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }
}
