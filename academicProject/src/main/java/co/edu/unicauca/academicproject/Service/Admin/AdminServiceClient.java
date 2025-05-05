package co.edu.unicauca.academicproject.Service.Admin;


import co.edu.unicauca.academicproject.entities.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lopez
 * @date 3/05/2025
 */
@Service
public class AdminServiceClient {

    @Autowired
    private AdminFeignClient FeignClient;

    public void approveCoordinator(Coordinator coordinator) {
        FeignClient.approveCoordinator(coordinator);
    }
}
