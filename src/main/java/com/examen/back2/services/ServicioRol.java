package com.examen.back2.services;

import com.examen.back2.DTO.RolDTO;
import com.examen.back2.maps.MapaRol;
import com.examen.back2.models.Rol;
import com.examen.back2.repository.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRol {

    @Autowired
    private RepositorioRol repositorio;

    @Autowired
    private MapaRol mapa;

    public org.springframework.http.ResponseEntity<List<RolDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Rol> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.rolTorolDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Rol no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(RolDTO dto) {
        try {
            Rol entity = mapa.rolDTOToRol(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.rolTorolDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el rol");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, RolDTO dto) {
        if (repositorio.existsById(id)) {
            Rol entity = mapa.rolDTOToRol(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.rolTorolDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Rol no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Rol eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Rol no encontrado para eliminar");
    }
}
