package co.edu.unicauca.academicproject.Service.Coordinator;

import co.edu.unicauca.academicproject.entities.Coordinator;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "GestionCoordinator-microservice",url = "http://localhost:8081")
public interface CoordinatorFeignClient {

    @PostMapping("/api/coordinator")
    void createCoordinator(@RequestBody Coordinator coordinator,@RequestHeader("Authorization") String token);

    @GetMapping("/api/coordinator")
    List<Coordinator> getAllCoordinators();

    @GetMapping("/api/coordinator/{code}")
    Coordinator getSCoordinatorByCode(@PathVariable Long code);

    @PutMapping("/api/coordinator/{code}")
    void updateCoordinator(@PathVariable Long code, @RequestBody Coordinator CoordinatorRequest);

    @DeleteMapping("/api/coordinator/{code}")
    void deleteCoordinator(@PathVariable Long code);

}
