package co.edu.unicauca.academicproject.Service.Admin;

import co.edu.unicauca.academicproject.entities.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Admin-microservice",url = "http://localhost:8081")
public interface AdminFeignClient {

    @PostMapping("/api/admin/coordinators/approve")
    void approveCoordinator(@RequestBody Coordinator coordinator
                            );



}
