package com.examen.back2.repository;

import com.examen.back2.models.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioRepuesto extends JpaRepository<Repuesto, Integer>{
    Optional<Repuesto>findById(Integer id);
    List<Repuesto>findByNumeroSerie(String numeroSerie);
    List<Repuesto>findByNombre(String nombre);
}
