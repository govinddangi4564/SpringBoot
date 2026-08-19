package com.example.AOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	// Runs before every method inside service package
	@Before("execution(* com.example.AOP.service.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("Before method: " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.AOP.service.*.*(..))")
	public void logWork() {
		System.out.println("This is log work");
	}

	// Runs after method completes
	@After("execution(* com.example.AOP.service.*.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		System.out.println("After method: " + joinPoint.getSignature().getName());
	}

	// Runs when method successfully returns
	@AfterReturning(pointcut = "execution(* com.example.AOP.service.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("Method returned: " + joinPoint.getSignature().getName());
		System.out.println("Result: " + result);
	}

	// Runs when method throws exception
	@AfterThrowing(pointcut = "execution(* com.example.AOP.service.*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		System.out.println("Exception in: " + joinPoint.getSignature().getName());
		System.out.println("Error: " + exception.getMessage());
	}

	@Around("execution(* com.example.AOP.service.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("Method started");

		long start = System.currentTimeMillis();

		Object result = joinPoint.proceed();

		long end = System.currentTimeMillis();

		System.out.println("Execution time: " + (end - start) + " ms");

		System.out.println("Method completed");

		return result;
	}
}
