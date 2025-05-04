package co.edu.unicauca.gestioncoordinadormicroservice.services;


import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.ProjectToApprove;
import co.edu.unicauca.gestioncoordinadormicroservice.repository.ICoordinatorRepository;
import co.edu.unicauca.gestioncoordinadormicroservice.repository.ProjectToApproveRepository;
import co.edu.unicauca.gestioncoordinadormicroservice.dto.ProyectoAprobadoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CoordiService {

    @Autowired
    private ICoordinatorRepository coordiRepository;

    public Coordinator saveCoordinator(Coordinator coordinator) {
        return coordiRepository.save(coordinator);
    }

    public List<Coordinator> getAllCoordinators() {
        return coordiRepository.findAll();
    }

    public Optional<Coordinator> getCoordinatorById(String id) {
        return coordiRepository.findById(id);
    }

    public Coordinator updateCoordinator(Coordinator coordinator) {
        return coordiRepository.save(coordinator);
    }

    public void deleteCoordinator(String id) {
        coordiRepository.deleteById(id);
    }

    @Autowired
    private ProjectToApproveRepository projectRepo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean aprobarProyecto(Long id) {
        Optional<ProjectToApprove> optional = projectRepo.findById(id);
        if (optional.isEmpty()) {
            return false;
        }

        ProjectToApprove proyecto = optional.get();
        proyecto.setStatus(ProjectToApprove.Status.APPROVED);
        projectRepo.save(proyecto);

        ProyectoAprobadoDTO dto = new ProyectoAprobadoDTO(
                proyecto.getExternalId(),
                proyecto.getTitle(),
                proyecto.getCompanyName()
        );

        rabbitTemplate.convertAndSend("proyectoAprobadoQueue", dto);
        System.out.println("Proyecto aprobado enviado por RabbitMQ: " + dto.getTitle());

        return true;
    }


}
