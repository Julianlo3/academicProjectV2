package co.edu.unicauca.coordinatorservice.infra.client;

import co.edu.unicauca.coordinatorservice.infra.config.FeignAuthForwardInterceptor;
import co.edu.unicauca.coordinatorservice.infra.dto.CreateProjectCommentDTO;
import co.edu.unicauca.coordinatorservice.infra.dto.ProjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "project-service",
        url = "http://localhost:8081",
        configuration = FeignAuthForwardInterceptor.class
)
public interface ProjectClient {

    @GetMapping("api/project/{id}")
    ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id);

    @PutMapping("api/project/{id}/approve")
    ResponseEntity<Void> approveProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto);

    @PutMapping("api/project/{id}/reject")
    ResponseEntity<Void> rejectProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto);

    @PutMapping("api/project/{id}/assign")
    ResponseEntity<Void> assignProject(@PathVariable Long id);

    @PutMapping("api/project/{id}/complete")
    ResponseEntity<Void> completeProject(@PathVariable Long id);
}
