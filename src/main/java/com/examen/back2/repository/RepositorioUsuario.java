package com.examen.back2.repository;
import com.examen.back2.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findById(Integer id);
    List<Usuario>findByUserName(String userName);
    Optional<Usuario> findByEmail(String email);
    boolean existsByUserName(String userName);
}
