package com.examen.back2.services;

import com.examen.back2.DTO.RepuestoDTO;
import com.examen.back2.maps.MapaRepuesto;
import com.examen.back2.models.Repuesto;
import com.examen.back2.repository.RepositorioRepuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRepuesto {

    @Autowired
    private RepositorioRepuesto repositorio;

    @Autowired
    private MapaRepuesto mapa;

    public org.springframework.http.ResponseEntity<List<RepuestoDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Repuesto> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.repuestoToRepuestoDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Repuesto no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(RepuestoDTO dto) {
        try {
            Repuesto entity = mapa.repuestoDTOToRepuesto(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.repuestoToRepuestoDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el repuesto");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, RepuestoDTO dto) {
        if (repositorio.existsById(id)) {
            Repuesto entity = mapa.repuestoDTOToRepuesto(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.repuestoToRepuestoDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Repuesto no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Repuesto eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Repuesto no encontrado para eliminar");
    }
}
