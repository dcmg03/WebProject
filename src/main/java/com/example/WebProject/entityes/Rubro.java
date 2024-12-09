package com.example.WebProject.entityes;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Rubro {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPresupuestoInicial() {
        return presupuestoInicial;
    }

    public void setPresupuestoInicial(Double presupuestoInicial) {
        this.presupuestoInicial = presupuestoInicial;
    }

    public Double getPresupuestoDisponible() {
        return presupuestoDisponible;
    }

    public void setPresupuestoDisponible(Double presupuestoDisponible) {
        this.presupuestoDisponible = presupuestoDisponible;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

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

