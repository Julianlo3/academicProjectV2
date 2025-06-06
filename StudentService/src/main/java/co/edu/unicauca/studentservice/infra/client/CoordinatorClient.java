package co.edu.unicauca.studentservice.infra.client;

import co.edu.unicauca.studentservice.infra.config.FeignAuthForwardInterceptor;
import co.edu.unicauca.studentservice.infra.dto.ProjectApplicationRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "coordinator-service",
        url = "http://localhost:8081",
        configuration = FeignAuthForwardInterceptor.class
)
public interface CoordinatorClient {

    @PostMapping("api/coordinator/request")
    void submitProjectApplication(ProjectApplicationRequestDTO request);
}