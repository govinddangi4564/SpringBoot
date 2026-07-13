package com.example.Schedular.entity;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimpleWork {
	
	@Scheduled(cron = "0 * * * * *")
	public void work() {
		System.out.println("Hello World");
	}
}
