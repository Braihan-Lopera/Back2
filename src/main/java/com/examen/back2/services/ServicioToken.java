package com.examen.back2.services;

import com.examen.back2.DTO.TokenDTO;
import com.examen.back2.maps.MapaToken;
import com.examen.back2.models.Token;
import com.examen.back2.repository.RepositorioToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioToken {

    @Autowired
    private RepositorioToken repositorio;

    @Autowired
    private MapaToken mapa;

    public org.springframework.http.ResponseEntity<List<TokenDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Token> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.tokenToTokenDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Token no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(TokenDTO dto) {
        try {
            Token entity = mapa.tokenDTOToToken(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.tokenToTokenDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el token");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, TokenDTO dto) {
        if (repositorio.existsById(id)) {
            Token entity = mapa.tokenDTOToToken(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.tokenToTokenDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Token no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Token eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Token no encontrado para eliminar");
    }
}
