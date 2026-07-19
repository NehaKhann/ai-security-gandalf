package com.neha.gandalfdefender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GandalfDefenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GandalfDefenderApplication.class, args);
    }

    // Used to make HTTP calls to the local Ollama server
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
