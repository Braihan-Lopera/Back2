package com.examen.back2.repository;
import com.examen.back2.assistance.Estado;
import com.examen.back2.models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface RepositorioRegistro extends JpaRepository<Registro, Integer> {
    Optional<Registro>findById(Integer id);
    List<Registro>findByEstado(Estado estado);
    List<Registro>findByFechaIngreso(LocalDate fechaIngreso);
}
