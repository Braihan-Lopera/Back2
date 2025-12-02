package com.examen.back2.controller;

import com.examen.back2.DTO.ClienteDTO;
import com.examen.back2.services.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControladorCliente {

    @Autowired
    private ServicioCliente servicio;

    @GetMapping("/todos")
    public ResponseEntity<List<ClienteDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping(value = "/guardar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardar(@RequestBody ClienteDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping(value = "/modificar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody ClienteDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
