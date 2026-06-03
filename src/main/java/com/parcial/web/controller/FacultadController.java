package com.parcial.web.controller;

import com.parcial.web.entity.Facultad;
import com.parcial.web.service.FacultadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/facultades")
@CrossOrigin(origins = "*")
public class FacultadController {

    private final FacultadService facultadService;

    public FacultadController(FacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping
    public List<Facultad> listar() {
        return facultadService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> buscarPorId(@PathVariable Long id) {
        return facultadService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Facultad crear(@RequestBody Facultad facultad) {
        return facultadService.crear(facultad);
    }

    @PutMapping("/{id}")
    public Facultad actualizar(@PathVariable Long id, @RequestBody Facultad facultad) {
        return facultadService.actualizar(id, facultad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        facultadService.eliminar(id);
    }
}