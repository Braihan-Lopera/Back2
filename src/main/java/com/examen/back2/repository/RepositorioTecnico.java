package com.examen.back2.repository;
import com.examen.back2.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioTecnico extends JpaRepository<Tecnico, Integer>{
    Optional<Tecnico>findById(Integer id);
    List<Tecnico>findByNombre(String nombre);
    List<Tecnico>findByDocumento(String documento);
    Optional<Tecnico>findByCorreo(String correo);
    Optional<Tecnico> findByCelular(String celular);
}
