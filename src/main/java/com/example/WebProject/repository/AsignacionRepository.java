package com.example.WebProject.repository;



import com.example.WebProject.entityes.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    // Métodos personalizados si es necesario
}
