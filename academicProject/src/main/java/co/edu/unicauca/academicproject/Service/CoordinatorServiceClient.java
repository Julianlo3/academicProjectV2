package co.edu.unicauca.academicproject.Service;


import co.edu.unicauca.academicproject.entities.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class CoordinatorServiceClient {
    @Autowired
    private GestionUsuarioFeignClient feignClient;

    public void createCoordinator(Coordinator coordinator) {
        feignClient.createCoordi(coordinator);
    }
}
