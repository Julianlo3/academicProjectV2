package co.edu.unicauca.gestioncoordinadormicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AssignmentService {

    private final RestTemplate restTemplate;

    @Autowired
    public AssignmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void assignStudentToProject(Long studentCode, Long projectCode) {
        String url = "http://localhost:8081/api/student/assignment";

        Map<String, Long> request = new HashMap<>();
        request.put("studentCode", studentCode);
        request.put("projectCode", projectCode);

        restTemplate.postForObject(url, request, Void.class);
    }
}