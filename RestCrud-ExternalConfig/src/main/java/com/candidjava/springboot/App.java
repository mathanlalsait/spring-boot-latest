package com.candidjava.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {
	
    
	public static void main(String[] args) {
		
		System.setProperty("spring.config.location", System.getProperty("user.home") + "/candid/application.yml");
	//	System.setProperty("server.port", "${application.portNumber}");
		
		
		SpringApplication.run(App.class, args);
	}
}
