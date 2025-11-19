package com.examen.back2.repository;
import com.examen.back2.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findById(Integer id);
    List<Cliente> findByDocumento(String documento);
    Optional<Cliente>findByCorreo(String correo);
    List<Cliente>findByNumeroCelular(String numeroCelular);
}
