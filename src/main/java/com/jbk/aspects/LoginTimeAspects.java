package com.jbk.aspects;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.stream.events.EndDocument;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginTimeAspects {
	Logger logger = LoggerFactory.getLogger(LoginTimeAspects.class);
//	@Before("execution(* com.jbk.controller.*.*(..))")
//	public void captureStartTime() {
//		System.out.println("Start time = " + LocalDateTime.now());
//	}
//
//	@After("execution(* com.jbk.controller.*.*(..))")
//	public void captureEndTime() {
//		System.out.println("End time = " + LocalDateTime.now());
//	}

	@Around("execution(* com.jbk.controller.*.*(..))")
	public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		//System.out.println("Start time = " + LocalDateTime.now());
		
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		
		logger.info("execution time="+(endTime-startTime));

		
		//		System.out.println("End time = " + LocalDateTime.now());
		return obj;

	}
}
