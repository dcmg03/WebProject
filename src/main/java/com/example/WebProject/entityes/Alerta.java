package com.example.WebProject.entityes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Ejemplo: "Falta de recursos", "Cercano al límite"

    private String mensaje;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;

    // Getters y Setters
}
