package com.example.WebProject.service;

import com.example.WebProject.entityes.Rubro;
import com.example.WebProject.repository.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RubroService {

    @Autowired
    private RubroRepository rubroRepository;

    public List<Rubro> obtenerTodos() {
        return rubroRepository.findAll();
    }

    public Optional<Rubro> obtenerPorId(Long id) {
        return rubroRepository.findById(id);
    }

    public Rubro guardar(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    public void eliminar(Long id) {
        rubroRepository.deleteById(id);
    }
    public List<Rubro> obtenerRubrosConAlertas() {
        return rubroRepository.findAll()
                .stream()
                .filter(r -> r.getPresupuestoDisponible().compareTo(BigDecimal.ZERO) <= 0)
                .toList();
    }
    public Map<String, BigDecimal> obtenerReporteGeneral() {
        return rubroRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Rubro::getNombre, Rubro::getPresupuestoDisponible));
    }


}
