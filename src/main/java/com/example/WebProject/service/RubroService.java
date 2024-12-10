package com.example.WebProject.service;



import com.example.WebProject.entityes.Rubro;
import com.example.WebProject.repository.RubroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroService {

    private final RubroRepository rubroRepository;

    public RubroService(RubroRepository rubroRepository) {
        this.rubroRepository = rubroRepository;
    }

    public List<Rubro> listarRubros() {
        return rubroRepository.findAll();
    }

    public Rubro guardarRubro(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    public Rubro crearRubro(Rubro rubro) {
        if (rubro.getPresupuestoInicial() == null || rubro.getPresupuestoInicial() <= 0) {
            throw new IllegalArgumentException("El presupuesto inicial debe ser mayor a 0");
        }
        rubro.setPresupuestoDisponible(rubro.getPresupuestoInicial());
        return rubroRepository.save(rubro);
    }


    public Rubro obtenerRubroPorId(Long id) {
        return rubroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rubro no encontrado con ID: " + id));
    }

    public Rubro actualizarRubro(Long id, Rubro rubroActualizado) {
        Rubro rubroExistente = obtenerRubroPorId(id); // Llama al método anterior
        rubroExistente.setNombre(rubroActualizado.getNombre());
        rubroExistente.setPresupuestoInicial(rubroActualizado.getPresupuestoInicial());
        rubroExistente.setPresupuestoDisponible(rubroActualizado.getPresupuestoDisponible());
        return rubroRepository.save(rubroExistente);
    }
    public void eliminarRubro(Long id) {
        if (!rubroRepository.existsById(id)) {
            throw new RuntimeException("Rubro no encontrado con ID: " + id);
        }
        rubroRepository.deleteById(id);
    }


}
