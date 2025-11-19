package com.examen.back2.repository;
import com.examen.back2.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Integer> {
    Optional<Rol> findById(Integer id);
    Optional<Rol> findByName(String name);
}
