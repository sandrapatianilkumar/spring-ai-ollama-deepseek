package com.anil.Controller;

import com.anil.service.ChatAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/ai")
public class ChatAIController {

    @Autowired
    private ChatAIService chatAIService;

    @GetMapping("/prompt")
    public String promptToAI(@RequestParam(value = "question") String question){
        return this.chatAIService
                .promptToDeepSeekAPI(question);
    }

    @GetMapping("/promptstream")
    public Flux<String> promptToAIStream(@RequestParam(value="question") String question){
        return this.chatAIService
                .promptToDeepSeekAPIStream(question);
    }

}
