package com.examen.back2.repository;


import com.examen.back2.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioToken extends JpaRepository<Token, Integer> {
    Optional<Token> findByToken(String token);
    List<Token> findByUsuarioId(Integer usuarioId);
    void deleteByToken(String token);
}
