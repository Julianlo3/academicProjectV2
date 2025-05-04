package com.academic_projects_prototype.companyMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceOfCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOfCompanyApplication.class, args);
	}

}
