package co.edu.unicauca.companyservice.services;

import co.edu.unicauca.companyservice.entities.Company;
import co.edu.unicauca.companyservice.entities.ProjectValuation;
import co.edu.unicauca.companyservice.entities.PublishProject;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {
    // Métodos relacionados con la gestión de empresas
    public Company getCompanyById(Long id);
    public Company createCompany(Company company);
    public Company updateCompany(Company company);
    public void deleteCompany(Long id);
    Optional<Company> findByNit(Long nit);
    Company updateByNit(Long nit, Company company);
    void deleteByNit(Long nit);

    // Métodos relacionados con la publicación de proyectos
    public PublishProject publishProject(Long companyId, PublishProject project); // Publicar proyecto por una empresa
    public List<PublishProject> getProjectsByCompany(Long companyId); // Obtener proyectos publicados por una empresa

    // Métodos relacionados con la valoración de proyectos
    public ProjectValuation addProjectValuation(Long projectId, ProjectValuation valuation); // Valorar un proyecto finalizado
    public List<ProjectValuation> getValuationsByProject(Long projectId); // Obtener las valoraciones de un proyecto
}
