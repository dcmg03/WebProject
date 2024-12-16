package com.example.WebProject.entityes;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rubro")
public class Rubro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private BigDecimal presupuestoInicial;

    private BigDecimal presupuestoDisponible;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPresupuestoInicial() { return presupuestoInicial; }
    public void setPresupuestoInicial(BigDecimal presupuestoInicial) { this.presupuestoInicial = presupuestoInicial; }

    public BigDecimal getPresupuestoDisponible() { return presupuestoDisponible; }
    public void setPresupuestoDisponible(BigDecimal presupuestoDisponible) { this.presupuestoDisponible = presupuestoDisponible; }
}
