package com.example.WebProject.controller;


import com.example.WebProject.entityes.Asignacion;
import com.example.WebProject.service.AsignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    public List<Asignacion> listarAsignaciones() {
        return asignacionService.listarAsignaciones();
    }

    @PostMapping
    public ResponseEntity<Asignacion> crearAsignacion(@RequestBody Asignacion asignacion) {
        return ResponseEntity.ok(asignacionService.guardarAsignacion(asignacion));
    }
}

