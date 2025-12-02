package com.examen.back2.services;

import com.examen.back2.DTO.PermisosDTO;
import com.examen.back2.maps.MapaPermisos;
import com.examen.back2.models.Permisos;
import com.examen.back2.repository.RepositorioPermisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPermisos {

    @Autowired
    private RepositorioPermisos repositorio;

    @Autowired
    private MapaPermisos mapa;

    public org.springframework.http.ResponseEntity<List<PermisosDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Permisos> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.permisosToPermisosDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Permiso no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(PermisosDTO dto) {
        try {
            Permisos entity = mapa.permisosDTOToPermisos(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.permisosToPermisosDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el permiso");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, PermisosDTO dto) {
        if (repositorio.existsById(id)) {
            Permisos entity = mapa.permisosDTOToPermisos(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.permisosToPermisosDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Permiso no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Permiso eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Permiso no encontrado para eliminar");
    }
}
