package com.example.WebProject.controller;


import com.example.WebProject.entityes.Rubro;
import com.example.WebProject.service.RubroService;
import org.springframework.http.HttpStatus;
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

    // Endpoint para listar todos los rubros
    @GetMapping
    public ResponseEntity<List<Rubro>> listarRubros() {
        List<Rubro> rubros = rubroService.listarRubros();
        return ResponseEntity.ok(rubros);
    }

    // Endpoint para obtener un rubro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rubro> obtenerRubroPorId(@PathVariable Long id) {
        Rubro rubro = rubroService.obtenerRubroPorId(id);
        return ResponseEntity.ok(rubro);
    }

    // Endpoint para crear un nuevo rubro
    @PostMapping
    public ResponseEntity<Rubro> crearRubro(@RequestBody Rubro rubro) {
        Rubro nuevoRubro = rubroService.crearRubro(rubro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRubro);
    }

    // Endpoint para actualizar un rubro existente
    @PutMapping("/{id}")
    public ResponseEntity<Rubro> actualizarRubro(@PathVariable Long id, @RequestBody Rubro rubroActualizado) {
        Rubro rubro = rubroService.actualizarRubro(id, rubroActualizado);
        return ResponseEntity.ok(rubro);
    }

    // Endpoint para eliminar un rubro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRubro(@PathVariable Long id) {
        rubroService.eliminarRubro(id);
        return ResponseEntity.noContent().build();
    }
}
