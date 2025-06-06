package co.edu.unicauca.coordinatorservice.infra.client;

import co.edu.unicauca.coordinatorservice.infra.config.FeignAuthForwardInterceptor;
import co.edu.unicauca.coordinatorservice.infra.dto.AssignmentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "student-service",
        url = "http://localhost:8081",
        configuration = FeignAuthForwardInterceptor.class
)
public interface StudentClient {

    @PostMapping("/api/student/assignment")
    void assignStudent(AssignmentRequestDTO request);
}
