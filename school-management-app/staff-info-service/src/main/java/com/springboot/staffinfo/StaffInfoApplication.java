package com.springboot.staffinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StaffInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffInfoApplication.class, args);
	}

}
