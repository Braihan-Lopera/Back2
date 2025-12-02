package com.examen.back2.services;

import com.examen.back2.DTO.UsuarioDTO;
import com.examen.back2.maps.MapaUsuario;
import com.examen.back2.models.Usuario;
import com.examen.back2.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repositorio;

    @Autowired
    private MapaUsuario mapa;

    public org.springframework.http.ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Usuario> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.usuarioToUsuarioDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Usuario no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(UsuarioDTO dto) {
        try {
            Usuario entity = mapa.usuarioDTOToUsuario(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.usuarioToUsuarioDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el usuario");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, UsuarioDTO dto) {
        if (repositorio.existsById(id)) {
            Usuario entity = mapa.usuarioDTOToUsuario(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.usuarioToUsuarioDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Usuario no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Usuario eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Usuario no encontrado para eliminar");
    }
}
