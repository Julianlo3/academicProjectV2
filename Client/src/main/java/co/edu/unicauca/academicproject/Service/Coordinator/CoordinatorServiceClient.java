package co.edu.unicauca.academicproject.Service.Coordinator;


import co.edu.unicauca.academicproject.entities.AssignmentRequest;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.CreateProjectComment;
import co.edu.unicauca.academicproject.entities.ProjectApplicationRequest;
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


    public Coordinator getCoordinatorByCode(Long code,String token){
        return FeignClient.getSCoordinatorByCode(code,token);
    }

    public void updateStudent(Long code, Coordinator coordinatorRequest){
        FeignClient.updateCoordinator(code, coordinatorRequest);
    }

    public void deleteCoordiantor(Long code){
        FeignClient.deleteCoordinator(code);
    }

    public List<ProjectApplicationRequest> getAllRequests(String token){
        return  FeignClient.getAllRequests(token);
    }

    public List<ProjectApplicationRequest> getAllRequestsByStudentCode(Long studentCode, String token){
        return FeignClient.getAllRequestsByStudentCode(studentCode, token);
    }

    public void acceptRequest(Long id,String token){
        FeignClient.acceptRequest(id,token);
    }

    public void rejectRequest(Long id,String token){
        FeignClient.rejectRequest(id,token);
    }

    public void approveProject(Long id, CreateProjectComment projectComment, String token){
        FeignClient.approveProject(id,projectComment,token);
    }

    public void rejectProject(Long id, CreateProjectComment projectComment, String token){
        FeignClient.rejectProject(id,projectComment,token);
    }

    public void completeProject(Long id, String token){
        FeignClient.completeProject(id,token);
    }

    public void assignProject(AssignmentRequest assignmentRequest, String token){
        FeignClient.assignProject(assignmentRequest,token);
    }

}
