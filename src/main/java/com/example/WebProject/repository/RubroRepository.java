package com.example.WebProject.repository;

import com.example.WebProject.entityes.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository extends JpaRepository<Rubro, Long> {
    // Métodos personalizados si es necesario
}
