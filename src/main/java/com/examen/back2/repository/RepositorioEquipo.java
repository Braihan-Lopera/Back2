package com.examen.back2.repository;
import com.examen.back2.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioEquipo extends JpaRepository<Equipo, Integer> {
    Optional<Equipo> findById(Integer id);
    Optional<Equipo> findByNumeroSerie(Integer numeroSerie);
    List<Equipo>findByMarca(String marca);
    List<Equipo>findByModelo(String modelo);
}
