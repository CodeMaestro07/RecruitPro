package com.jbk;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com")
@ComponentScan("com")
@SpringBootApplication
public class RecruitProApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecruitProApplication.class, args);
		System.out.println("app started...."); 
		
	}

}
