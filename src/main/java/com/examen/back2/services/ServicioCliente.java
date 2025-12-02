package com.examen.back2.services;
import com.examen.back2.DTO.ClienteDTO;
import com.examen.back2.maps.MapaCliente;
import com.examen.back2.models.Cliente;
import com.examen.back2.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente {
    @Autowired
    private RepositorioCliente repositorio;

    @Autowired
    private MapaCliente mapa;

    public org.springframework.http.ResponseEntity<List<ClienteDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Cliente> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.clienteToClienteDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Cliente no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(ClienteDTO dto) {
        try {
            Cliente entity = mapa.clienteDTOToCliente(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.clienteToClienteDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el cliente");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, ClienteDTO dto) {
        if (repositorio.existsById(id)) {
            Cliente entity = mapa.clienteDTOToCliente(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.clienteToClienteDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Cliente no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Cliente eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Cliente no encontrado para eliminar");
    }
}
