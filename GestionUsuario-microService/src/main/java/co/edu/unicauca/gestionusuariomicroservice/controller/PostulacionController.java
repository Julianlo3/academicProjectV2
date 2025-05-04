package co.edu.unicauca.gestionusuariomicroservice.controller;


import co.edu.unicauca.gestionusuariomicroservice.Service.PostulacionService;
import co.edu.unicauca.gestionusuariomicroservice.entities.Postulacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lopez
 * @date 15/04/2025
 */
@RestController
@RequestMapping("/postulacion")
public class PostulacionController {

    @Autowired
    private PostulacionService postulacionService;

    @PostMapping
    public ResponseEntity<Postulacion> crear(@RequestBody Postulacion postulacion) {
        return new ResponseEntity<>(postulacionService.crearPostulacion(postulacion), HttpStatus.CREATED);
    }

    @GetMapping("/postulacion/{code}")
    public List<Postulacion> getPorEstudiante(@PathVariable String code) {
        return postulacionService.obtenerPorEstudiante(code);
    }

    @GetMapping("/postulacion/{title}")
    public List<Postulacion> getPorProject(@PathVariable String title) {
        return postulacionService.findByProjecTitle(title);
    }

}
