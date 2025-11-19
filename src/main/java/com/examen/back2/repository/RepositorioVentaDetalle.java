package com.examen.back2.repository;

import com.examen.back2.models.Factura;
import com.examen.back2.models.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioVentaDetalle extends JpaRepository<VentaDetalle, Integer> {
    Optional<VentaDetalle>findById(Integer id);
    List<VentaDetalle>findByFactura(Factura factura);
    List<VentaDetalle> findByProductoId(Integer productoId);
}
