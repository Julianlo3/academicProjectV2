package co.edu.unicauca.coordinatorservice.infra.client;

import co.edu.unicauca.coordinatorservice.infra.config.FeignAuthForwardInterceptor;
import co.edu.unicauca.coordinatorservice.infra.dto.AssignmentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(
        name = "project-service",
        url = "http://localhost:8081",
        configuration = FeignAuthForwardInterceptor.class
)
public interface ProjectClient {

    @PutMapping("api/project/{id}/assign")
    void assignProject(@PathVariable Long id);
}
