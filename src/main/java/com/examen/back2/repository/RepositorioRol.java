package com.examen.back2.repository;
import com.examen.back2.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Integer> {
}
