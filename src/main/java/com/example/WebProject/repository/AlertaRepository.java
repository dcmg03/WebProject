package com.example.WebProject.repository;



import com.example.WebProject.entityes.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    // Métodos personalizados si es necesario
}
