package co.edu.unicauca.academicproject.Service.Coordinator;

import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "GestionCoordinator-microservice",url = "http://localhost:8080")
public interface CoordinatorFeignClient {

    @PostMapping("/coordinator")
    void createCoordinator(@RequestBody Coordinator coordinator);

    @GetMapping("/coordinator")
    List<Coordinator> getAllCoordinators();

    @GetMapping("/coordinator/{code}")
    Coordinator getSCoordinatorByCode(@PathVariable Long code);

    @PutMapping("/coordinator/{code}")
    void updateCoordinator(@PathVariable Long code, @RequestBody Coordinator CoordinatorRequest);

    @DeleteMapping("/coordinator/{code}")
    void deleteCoordinator(@PathVariable Long code);
}
