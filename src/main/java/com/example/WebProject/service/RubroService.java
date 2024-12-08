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
}
