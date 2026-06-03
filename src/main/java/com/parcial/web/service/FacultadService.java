package com.parcial.web.service;

import com.parcial.web.entity.Facultad;
import com.parcial.web.repository.FacultadRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadService(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    public List<Facultad> listar() {
        return facultadRepository.findAll();
    }

    public Optional<Facultad> buscarPorId(Long id) {
        return facultadRepository.findById(id);
    }

    public Facultad crear(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    public Facultad actualizar(Long id, Facultad facultad) {
        facultad.setId(id);
        return facultadRepository.save(facultad);
    }

    public void eliminar(Long id) {
        facultadRepository.deleteById(id);
    }
}