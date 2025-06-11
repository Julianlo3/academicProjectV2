package co.edu.unicauca.academicproject.Service.Coordinator;

import co.edu.unicauca.academicproject.entities.AssignmentRequest;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.CreateProjectComment;
import co.edu.unicauca.academicproject.entities.ProjectApplicationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "GestionCoordinator-microservice",url = "http://localhost:8081")
public interface CoordinatorFeignClient {

    @PostMapping("/api/coordinator")
    void createCoordinator(@RequestBody Coordinator coordinator,@RequestHeader("Authorization") String token);

    @GetMapping("/api/coordinator")
    List<Coordinator> getAllCoordinators(@RequestHeader("Authorization") String token);

    @GetMapping("/api/coordinator/{code}")
    Coordinator getSCoordinatorByCode(@PathVariable Long code,@RequestHeader("Authorization") String token);

    @PutMapping("/api/coordinator/{code}")
    void updateCoordinator(@PathVariable Long code, @RequestBody Coordinator CoordinatorRequest);

    @DeleteMapping("/api/coordinator/{code}")
    void deleteCoordinator(@PathVariable Long code);

    @GetMapping("/api/coordinator/request")
    List<ProjectApplicationRequest> getAllRequests(@RequestHeader("Authorization") String token);

    @GetMapping("/api/coordinator/request/student/{studentCode}")
    List<ProjectApplicationRequest> getAllRequestsByStudentCode(@PathVariable Long studentCode, @RequestHeader("Authorization") String token);

    @PutMapping("api/coordinator/request/{id}/accept")
    void acceptRequest(@PathVariable Long id,@RequestHeader("Authorization") String token);

    @PutMapping("api/coordinator/request/{id}/reject")
    void rejectRequest(@PathVariable Long id,@RequestHeader("Authorization") String token);

    @PutMapping("api/coordinator/project/{id}/approve")
    void approveProject(@PathVariable Long id, @RequestBody CreateProjectComment projectComment, @RequestHeader("Authorization") String token);

    @PutMapping("api/coordinator/project/{id}/reject")
    void rejectProject(@PathVariable Long id, @RequestBody CreateProjectComment projectComment, @RequestHeader("Authorization") String token);

    @PutMapping("api/coordinator/project/assign")
    void assignProject(@RequestBody AssignmentRequest assignmentRequest, @RequestHeader("Authorization") String token);

    @PutMapping("api/coordinator/project/{id}/complete")
    void completeProject(@PathVariable Long id, @RequestHeader("Authorization") String token);
}
