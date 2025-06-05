package co.edu.unicauca.academicproject.Service.Coordinator;


import co.edu.unicauca.academicproject.entities.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class CoordinatorServiceClient {

    @Autowired
    private CoordinatorFeignClient FeignClient;

    public void createCoordinator(Coordinator coordinator,String token) {
        FeignClient.createCoordinator(coordinator, token);
   }

    public List<Coordinator> GetAllCoordinators(String token){
        return FeignClient.getAllCoordinators(token);
    }


    public Coordinator getCoordinatorByCode(Long code){
        return FeignClient.getSCoordinatorByCode(code);
    }

    public void updateStudent(Long code, Coordinator coordinatorRequest){
        FeignClient.updateCoordinator(code, coordinatorRequest);
    }

    public void deleteCoordiantor(Long code){
        FeignClient.deleteCoordinator(code);
    }

}
