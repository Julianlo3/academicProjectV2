package com.academic_projects_prototype.companyMicroservice.controllers;

import com.academic_projects_prototype.companyMicroservice.client.ProjectServiceClient;
import com.academic_projects_prototype.companyMicroservice.entities.Company;
import com.academic_projects_prototype.companyMicroservice.entities.ProjectValuation;
import com.academic_projects_prototype.companyMicroservice.entities.PublishProject;
import com.academic_projects_prototype.companyMicroservice.infra.dto.projectDTO.ProjectRequestDTO;
import com.academic_projects_prototype.companyMicroservice.infra.dto.projectDTO.ProjectResponseDTO;
import com.academic_projects_prototype.companyMicroservice.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final ICompanyService companyService;
    private final ProjectServiceClient projectServiceClient;

    @Autowired
    public CompanyController(ICompanyService companyService, ProjectServiceClient projectServiceClient) {
        this.companyService = companyService;
        this.projectServiceClient = projectServiceClient;
    }

    // Obtener una empresa por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable Long id) {
        try{
            Company company = companyService.getCompanyById(id);
            return ResponseEntity.ok(company);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Crear una nueva empresa
    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    // Actualizar una empresa existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody Company company){
        try{
            company.setId(id); // asegurar que el id coincida
            Company updatedCompany = companyService.updateCompany(company);
            return ResponseEntity.ok(updatedCompany);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Eliminar una empresa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){
        try{
            companyService.deleteCompany(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Publicar un proyecto
    @PostMapping("/{companyId}/projects/publish")
    public ResponseEntity<?> publishProject(@PathVariable Long companyId, @RequestBody PublishProject project){
        try{
            PublishProject publishedProject = companyService.publishProject(companyId, project);
            return ResponseEntity.status(HttpStatus.CREATED).body(publishedProject);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Obtener todos los proyectos de una empresa
    @GetMapping("/{companyId}/projects")
    public ResponseEntity<?> getProjectsByCompany(@PathVariable Long companyId){
        try{
            List<PublishProject> projects = companyService.getProjectsByCompany(companyId);
            return ResponseEntity.ok(projects);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Agregar una valoración de proyecto
    @PostMapping("/{projectId}/valuations")
    public ResponseEntity<?> addProjectValuation(@PathVariable Long projectId, @RequestBody ProjectValuation valuation){
        try{
            ProjectValuation addedValuation = companyService.addProjectValuation(projectId, valuation);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedValuation);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Obtener valoraciones de un proyecto
    @GetMapping("/{projectId}/valuations")
    public ResponseEntity<List<ProjectValuation>> getValuationsByProject(@PathVariable Long projectId){
        try{
            List<ProjectValuation> valuations = companyService.getValuationsByProject(projectId);
            return ResponseEntity.ok(valuations);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Endpoint para crear un nuevo proyecto llamando al microservicio de proyecto
     */
    @PostMapping("/proyectos")
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        return projectServiceClient.createProject(projectRequestDTO);
    }

    /**
     * Endpoint para obtener un proyecto por ID llamando al microservicio de proyecto
     */
    @GetMapping("/proyectos/{projectId}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long projectId) {
        return projectServiceClient.getProjectById(projectId);
    }

    // OPERACIONES POR NIT
    @GetMapping("/search")
    public ResponseEntity<Company> getCompanyByNit(@RequestParam("nit") Long nit) {
        Optional<Company> company = companyService.findByNit(nit);
        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateByNit/{nit}")
    public ResponseEntity<?> updateCompanyByNit(@PathVariable Long nit, @RequestBody Company company) {
        try {
            Company updatedCompany = companyService.updateByNit(nit, company);
            return ResponseEntity.ok(updatedCompany);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with NIT " + nit + " not found.");
        }
    }

    @DeleteMapping("/deleteByNit/{nit}")
    public ResponseEntity<?> deleteCompanyByNit(@PathVariable Long nit) {
        try {
            companyService.deleteByNit(nit);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with NIT " + nit + " not found.");
        }
    }
}
