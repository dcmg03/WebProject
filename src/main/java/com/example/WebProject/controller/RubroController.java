package com.example.WebProject.controller;


import com.example.WebProject.entityes.Rubro;
import com.example.WebProject.service.RubroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rubros")
public class RubroController {

    private final RubroService rubroService;

    public RubroController(RubroService rubroService) {
        this.rubroService = rubroService;
    }

    @GetMapping
    public List<Rubro> listarRubros() {
        return rubroService.listarRubros();
    }

    @PostMapping
    public ResponseEntity<Rubro> crearRubro(@RequestBody Rubro rubro) {
        return ResponseEntity.ok(rubroService.guardarRubro(rubro));
    }
}
