package com.neha.gandalfdefender.chat.dto;

import jakarta.validation.constraints.NotBlank;

public class GuessRequest {

    @NotBlank(message = "guess must not be empty")
    private String guess;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
}
