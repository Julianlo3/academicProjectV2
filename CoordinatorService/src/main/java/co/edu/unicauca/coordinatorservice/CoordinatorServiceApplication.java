package co.edu.unicauca.coordinatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication

@EnableFeignClients
public class CoordinatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordinatorServiceApplication.class, args);
	}

}
