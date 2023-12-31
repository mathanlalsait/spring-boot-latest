package com.example.howtodoinjava.springeurekaclientschoolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringEurekaClientSchoolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientSchoolServiceApplication.class, args);
	}
}
