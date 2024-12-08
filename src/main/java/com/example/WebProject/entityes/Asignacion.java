package com.example.WebProject.entityes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private Double monto;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;

    // Getters y Setters
}
