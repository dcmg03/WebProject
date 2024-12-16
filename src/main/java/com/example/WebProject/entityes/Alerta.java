package com.example.WebProject.entityes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Alerta {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Ejemplo: "Falta de recursos", "Cercano al límite"

    private String mensaje;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;

}
