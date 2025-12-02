package com.examen.back2.services;

import com.examen.back2.DTO.EquipoDTO;
import com.examen.back2.maps.MapaEquipo;
import com.examen.back2.models.Equipo;
import com.examen.back2.repository.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioEquipo {

    @Autowired
    private RepositorioEquipo repositorio;

    @Autowired
    private MapaEquipo mapa;

    public org.springframework.http.ResponseEntity<List<EquipoDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Equipo> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.equipoToEquipoDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Equipo no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(EquipoDTO dto) {
        try {
            Equipo entity = mapa.equipoDTOToEquipo(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.equipoToEquipoDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el equipo");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, EquipoDTO dto) {
        if (repositorio.existsById(id)) {
            Equipo entity = mapa.equipoDTOToEquipo(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.equipoToEquipoDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Equipo no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Equipo eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Equipo no encontrado para eliminar");
    }
}
