package com.example.SpringWebSocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	// URL: http://localhost:8080/chat?user=Alex
	@GetMapping("/chat")
	public String openChatPage(@RequestParam(name = "user", defaultValue = "Guest") String username, Model model) {

		// Pass username to the Thymeleaf template
		model.addAttribute("username", username);

		// Returns src/main/resources/templates/chat.html
		return "chat";
	}
}