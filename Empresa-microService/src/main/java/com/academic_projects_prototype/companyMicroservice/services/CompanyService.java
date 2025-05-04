package com.academic_projects_prototype.companyMicroservice.services;

import com.academic_projects_prototype.companyMicroservice.entities.Company;
import com.academic_projects_prototype.companyMicroservice.entities.ProjectValuation;
import com.academic_projects_prototype.companyMicroservice.entities.PublishProject;
import com.academic_projects_prototype.companyMicroservice.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    private final CompanyRepository companyRepository;
    private final RestTemplate restTemplate;
    private final String projectServiceBaseUrl = "http://project-microservice/api/projects"; // URL base del microservicio de proyectos

    @Autowired
    public CompanyService(CompanyRepository companyRepository, RestTemplate restTemplate) {
        this.companyRepository = companyRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isEmpty()){
            throw new RuntimeException("No existe una empresa con el id " + id);
        }
        return company.get();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        if (!companyRepository.existsById(company.getId())) {
            throw new RuntimeException("La empresa con id: " + company.getId() + " no fue encontrada");
        }
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("La empresa con id: " + id + " no fue encontrada");
        }
        companyRepository.deleteById(id);
    }

    @Override
    public PublishProject publishProject(Long companyId, PublishProject project) {
        // Verificar que la empresa existe
        if(!companyRepository.existsById(companyId)){
            throw new RuntimeException("La empresa con id: " + companyId + " no fue encontrada");
        }
        // Enviar la publicación al microservicio de proyectos
        project.setCompanyId(companyId); // Asignar la empresa al proyecto
        PublishProject publishedProject = restTemplate.postForObject(projectServiceBaseUrl + "/publish", project, PublishProject.class);
        if(publishedProject == null){
            throw new RuntimeException("No se pudo publicar el proyecto");
        }
        return publishedProject;
    }

    @Override
    public List<PublishProject> getProjectsByCompany(Long companyId) {
        // Verificar que la empresa existe
        if(!companyRepository.existsById(companyId)){
            throw new RuntimeException("La empresa con id: " + companyId + " no fue encontrada");
        }
        // Obtener los proyectos usando el microservicio de proyectos
        String url = projectServiceBaseUrl + "/company/" + companyId + "/projects";
        return List.of(restTemplate.getForObject(url, PublishProject[].class));
    }

    @Override
    public ProjectValuation addProjectValuation(Long projectId, ProjectValuation valuation) {
        // Validar que el proyecto existe (llamando al micro de proyectos)
        String projectUrl = projectServiceBaseUrl + "/" + projectId;
        Boolean projectExists = restTemplate.getForObject(projectUrl + "/exist", Boolean.class);
        if(Boolean.FALSE.equals(projectExists)){
            throw new RuntimeException("El proyecto con id: " + projectId + " no existe");
        }
        // Registrar la valoración
        valuation.setProjectId(projectId);
        valuation.setCreatedAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));
        return valuation; // retornar la valoración creada
    }

    @Override
    public List<ProjectValuation> getValuationsByProject(Long projectId) {
        // Validar que el proyecto existe
        String projectUrl = projectServiceBaseUrl + "/" + projectId;
        Boolean projectExists = restTemplate.getForObject(projectUrl + "/exist", Boolean.class);
        if(Boolean.FALSE.equals(projectExists)){
            throw new RuntimeException("El proyecto con id: " + projectId + " no existe");
        }
        return List.of(); // retornar las valoraciones
    }
}