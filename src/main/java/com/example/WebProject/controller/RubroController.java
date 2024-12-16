package com.example.WebProject.controller;

import com.example.WebProject.entityes.Rubro;
import com.example.WebProject.service.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rubros")
public class RubroController {

    @Autowired
    private RubroService rubroService;

    @GetMapping
    public List<Rubro> obtenerTodos() {
        return rubroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rubro> obtenerPorId(@PathVariable Long id) {
        return rubroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rubro crear(@RequestBody Rubro rubro) {
        return rubroService.guardar(rubro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rubro> actualizar(@PathVariable Long id, @RequestBody Rubro rubro) {
        return rubroService.obtenerPorId(id)
                .map(existing -> {
                    existing.setNombre(rubro.getNombre());
                    existing.setPresupuestoInicial(rubro.getPresupuestoInicial());
                    existing.setPresupuestoDisponible(rubro.getPresupuestoDisponible());
                    return ResponseEntity.ok(rubroService.guardar(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rubroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/alertas")
    public List<Rubro> obtenerRubrosConAlertas() {
        return rubroService.obtenerRubrosConAlertas();
    }
    @GetMapping("/reportes")
    public Map<String, BigDecimal> obtenerReporteGeneral() {
        return rubroService.obtenerReporteGeneral();
    }

}
