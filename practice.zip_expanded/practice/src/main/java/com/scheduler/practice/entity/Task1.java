package com.scheduler.practice.entity;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task1 {

//	┌───────────── Second (0-59)
//	│ ┌─────────── Minute (0-59)
//	│ │ ┌───────── Hour (0-23)
//	│ │ │ ┌─────── Day of Month (1-31)
//	│ │ │ │ ┌───── Month (1-12 or JAN-DEC)
//	│ │ │ │ │ ┌─── Day of Week (0-7 or SUN-SAT)
//	│ │ │ │ │ │
//	* * * * * *

//	// 1. Run a method every 5 seconds
//	@Scheduled(fixedRate = 5000)
//	public void print() {
//		System.out.println("Hello World");
//	}

//	// 2. Run a task every minute
//	@Scheduled(cron = "0 * * * * *")
//	public void print() {
//		System.out.println("Hello World");
//	}

//	// 3. Run a task daily at 9:30 AM
//	@Scheduled(cron = "0 30 9 * * *")
//	public void print() {
//		System.out.println("Hello World");
//	}

//	// 4. Run a job every Monday at 10 AM
//	@Scheduled(cron = "0 0 10 * * MON")
//	public void print() {
//		System.out.println("Hello World");
//	}

//	// 5.  Run a task every 10 minutes
//	@Scheduled(cron = "0 */10 * * * *")
//	public void print() {
//		System.out.println("Hello World");
//	}
	
//	// 6. Run a task every weekday at 6 PM
//	@Scheduled(cron = "0 0 18 * * MON-FRI")
//	public void print() {
//		System.out.println("Hello World");
//	}
	
//	// 7. Run a task on the 1st of every month
//	@Scheduled(cron = "0 0 0 1 * *")
//	public void print() {
//		System.out.println("Hello World");
//	}
	
//	// 8. Run a job every 30 seconds
//	@Scheduled(cron = "0/30 * * * * *")
//	public void print() {
//		System.out.println("Hello World");
//	}
	
//	// 9. Run a cleanup job every Sunday at midnight
//	@Scheduled(cron = "0 0 0 * * SUN")
//	public void print() {
//		System.out.println("Hello World");
//	}
	
//	// 10. Run a job every 2 hours
//	@Scheduled(cron = "0 0 0/2 * * *")
//	public void print() {
//		System.out.println("Hello World");
//	}
	
	// 11. Fetch stock prices every 10 seconds and store in DB
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	// 12. Send email only if there are pending records
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	// 13. Run a task only between 9 AM to 5 PM (every 15 min) 
//	@Scheduled(cron = "0 0/15 9-17 * * *")
//	public void print() {
//		System.out.println("Hello World");
//	}
	

	
	
	
	
	
	
	
	
	
	
	
}
