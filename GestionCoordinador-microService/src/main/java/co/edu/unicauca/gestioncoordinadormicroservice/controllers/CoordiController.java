package co.edu.unicauca.gestioncoordinadormicroservice.controllers;

import co.edu.unicauca.gestioncoordinadormicroservice.services.CoordiService;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coordinator")
public class CoordiController {

    @Autowired
    private CoordiService coordiService;

    @PostMapping
    public ResponseEntity<Coordinator> createCoordinator(@RequestBody Coordinator coordinator) {
        Coordinator savedCoordi = coordiService.saveCoordinator(coordinator);
        return new ResponseEntity<>(savedCoordi, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Coordinator>> getAllCoordinators() {
        List<Coordinator> coordi = coordiService.getAllCoordinators();
        return new ResponseEntity<>(coordi, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Coordinator> getCoordinatorById(@PathVariable long code) {
        Optional<Coordinator> coordi = coordiService.getCoordinatorById(String.valueOf(code));
        return coordi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{code}")
    public ResponseEntity<Coordinator> updateCoordinator(@PathVariable long code, @RequestBody Coordinator coordi) {
        if (!coordiService.getCoordinatorById(String.valueOf(code)).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        coordi.setCode(code);
        Coordinator updatedCoordi = coordiService.updateCoordinator(coordi);
        return new ResponseEntity<>(updatedCoordi, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCoordinator(@PathVariable long code) {
        coordiService.deleteCoordinator(String.valueOf(code));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/project/approve/{id}")
    public ResponseEntity<String> aprobarProyecto(@PathVariable Long id) {
        boolean aprobado = coordiService.aprobarProyecto(id);
        if (!aprobado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Proyecto aprobado con éxito");
    }
}
