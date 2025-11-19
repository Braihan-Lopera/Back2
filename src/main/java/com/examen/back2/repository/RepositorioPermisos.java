package com.examen.back2.repository;

import com.examen.back2.models.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioPermisos extends JpaRepository<Permisos, Integer> {
    Optional<Permisos>findById(Integer id);
    Optional<Permisos> findByTipoPermiso(String tipoPermiso);

}
