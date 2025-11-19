package com.examen.back2.repository;

import com.examen.back2.models.Producto;
import com.examen.back2.models.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioProducto extends JpaRepository<Producto, Integer>{
    Optional<Producto>findById(Integer id);
    List<Producto>findByNombre(String nombre);
    List<Producto>findByNumeroSerie(String numeroSerie);
}
