package com.candidjava.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdProfileConfiguration {
	
    @Value("${message}")
    private String message;
    
    @Bean
    public void prod() {
        System.out.println(message);
    }
}
