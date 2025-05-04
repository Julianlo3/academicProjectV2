package co.edu.unicauca.academicproject.Service.Admin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "Admin-microservice",url = "http://localhost:8083")
public interface AdminFeignClient {



}
