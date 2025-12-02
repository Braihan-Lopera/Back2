package com.examen.back2.services;

import com.examen.back2.DTO.TecnicoDTO;
import com.examen.back2.maps.MapaTecnico;
import com.examen.back2.models.Tecnico;
import com.examen.back2.repository.RepositorioTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioTecnico {

    @Autowired
    private RepositorioTecnico repositorio;

    @Autowired
    private MapaTecnico mapa;

    public org.springframework.http.ResponseEntity<List<TecnicoDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Tecnico> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.tecnicoToTecnicoDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Tecnico no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(TecnicoDTO dto) {
        try {
            Tecnico entity = mapa.tecnicoDTOToTecnico(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.tecnicoToTecnicoDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el tecnico");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, TecnicoDTO dto) {
        if (repositorio.existsById(id)) {
            Tecnico entity = mapa.tecnicoDTOToTecnico(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.tecnicoToTecnicoDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Tecnico no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Tecnico eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Tecnico no encontrado para eliminar");
    }
}
