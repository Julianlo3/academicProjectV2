package co.edu.unicauca.gestioncoordinadormicroservice.listener;

import co.edu.unicauca.gestioncoordinadormicroservice.dto.ProyectoPublicadoDTO;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.ProjectToApprove;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.ProjectToApprove.Status;
import co.edu.unicauca.gestioncoordinadormicroservice.repository.ProjectToApproveRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoPublicadoListener {

    @Autowired
    private ProjectToApproveRepository repository;

    @RabbitListener(queues = "proyectoPublicadoQueue")
    public void recibirProyectoPublicado(ProyectoPublicadoDTO dto) {
        System.out.println("Proyecto recibido: " + dto.getTitle());

        ProjectToApprove nuevo = new ProjectToApprove();
        nuevo.setExternalId(dto.getId());
        nuevo.setTitle(dto.getTitle());
        nuevo.setDescription(dto.getDescription());
        nuevo.setCompanyName(dto.getCompanyName());
        nuevo.setStatus(Status.PENDING);

        repository.save(nuevo);

        System.out.println("Proyecto guardado en base de datos como PENDING.");
    }
}