package com.anil.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatAIService {
    private final ChatClient chatClient;

    public ChatAIService(ChatClient.Builder charClientBuilder) {
        this.chatClient = charClientBuilder.build();
    }

    public String promptToDeepSeekAPI(String question) {
        return this.chatClient.prompt(question)
                .call()
                .content();
    }

    public Flux<String> promptToDeepSeekAPIStream(String question) {
        return this.chatClient.prompt(question)
                .stream()
                .content();
    }
}
