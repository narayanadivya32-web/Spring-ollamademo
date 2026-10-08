package com.project.OpenAi.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

   public  ChatController(ChatClient.Builder chatClientBuilder){
       this.chatClient = chatClientBuilder.build();
   }

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message){
return chatClient.prompt()
        .system("Your an internal HR Assistand. Your role is to help\s Employee with questions related to leave policy, working hours,benifits,and code of conduct. If a user ask anything outside of these topics, \s kindly inform them that you can only assist with only HR related ."
                 )
        .user(message)
        .call()
        .content();

    }

}
