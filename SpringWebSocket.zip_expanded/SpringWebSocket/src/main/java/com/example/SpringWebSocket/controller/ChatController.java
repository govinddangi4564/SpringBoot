package com.example.SpringWebSocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.SpringWebSocket.dto.ChatMessage;

@Controller
public class ChatController {

    // When a client sends a message to "/app/chat.sendMessage", 
    // this method processes it and broadcasts it to everyone watching "/topic/public".
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    // When a client sends a join notification to "/app/chat.addUser"
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage) {
        chatMessage.setContent(chatMessage.getSender() + " joined the chat!");
        return chatMessage;
    }
}
