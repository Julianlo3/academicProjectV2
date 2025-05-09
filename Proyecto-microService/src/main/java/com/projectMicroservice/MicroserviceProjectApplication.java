package com.projectMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class MicroserviceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProjectApplication.class, args);
	}

}
