package co.edu.unicauca.gestionusuariomicroservice.controller;


import co.edu.unicauca.gestionusuariomicroservice.Service.CoordiService;
import co.edu.unicauca.gestionusuariomicroservice.entities.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author lopez
 * @date 15/04/2025
 */
@RestController
@RequestMapping("/coordinator")
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

    @GetMapping("/{id}")
    public ResponseEntity<Coordinator> getCoordinatorById(@PathVariable String id) {
        Optional<Coordinator> coordi = coordiService.getCoordinatorById(id);
        return coordi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordinator> updateCoordinator(@PathVariable String id, @RequestBody Coordinator coordi) {
        if (!coordiService.getCoordinatorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        coordi.setCode(id);
        Coordinator updatedCoordi = coordiService.updateCoordinator(coordi);
        return new ResponseEntity<>(updatedCoordi, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordinator(@PathVariable String id) {
        coordiService.deleteCoordinator(id);
        return ResponseEntity.noContent().build();
    }
}
