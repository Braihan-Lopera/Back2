package com.examen.back2.repository;

import com.examen.back2.models.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPermisos extends JpaRepository<Permisos, Integer> {

}
