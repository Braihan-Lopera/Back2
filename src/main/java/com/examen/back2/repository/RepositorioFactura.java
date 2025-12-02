package com.examen.back2.repository;
import com.examen.back2.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface RepositorioFactura extends JpaRepository<Factura, Integer> {

    Optional<Factura> findById(Integer id);

    List<Factura> findByFechaEmision(LocalDate fechaEmision);

    List<Factura> findByFechaEmisionBetween(LocalDate fechaInicio, LocalDate fechaFin);
}
