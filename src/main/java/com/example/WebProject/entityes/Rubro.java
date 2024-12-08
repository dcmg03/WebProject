package com.example.WebProject.entityes;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Rubro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double presupuestoInicial;

    private Double presupuestoDisponible;

    @OneToMany(mappedBy = "rubro", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

    // Getters y Setters
}

