package com.examen.back2.services;

import com.examen.back2.DTO.RegistroDTO;
import com.examen.back2.maps.MapaRegistro;
import com.examen.back2.models.Registro;
import com.examen.back2.repository.RepositorioRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRegistro {

    @Autowired
    private RepositorioRegistro repositorio;

    @Autowired
    private MapaRegistro mapa;

    public org.springframework.http.ResponseEntity<List<RegistroDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Registro> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.registroToRegistroDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Registro no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(RegistroDTO dto) {
        try {
            Registro entity = mapa.registroDTOToRegistro(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.registroToRegistroDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el registro");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, RegistroDTO dto) {
        if (repositorio.existsById(id)) {
            Registro entity = mapa.registroDTOToRegistro(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.registroToRegistroDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Registro no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Registro eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Registro no encontrado para eliminar");
    }
}
