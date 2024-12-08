package com.example.WebProject.service;



import com.example.WebProject.entityes.Asignacion;
import com.example.WebProject.repository.AsignacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;

    public AsignacionService(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    public List<Asignacion> listarAsignaciones() {
        return asignacionRepository.findAll();
    }

    public Asignacion guardarAsignacion(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }
}
