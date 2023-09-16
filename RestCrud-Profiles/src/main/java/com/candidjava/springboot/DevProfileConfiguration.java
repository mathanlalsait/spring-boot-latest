package com.candidjava.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfileConfiguration {
	
    @Value("${message}")
    private String message;
    
    @Bean
    public void dev() {
        System.out.println(message);
    }
}
