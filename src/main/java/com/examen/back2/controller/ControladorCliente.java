package com.examen.back2.controller;

import com.examen.back2.DTO.ClienteDTO;
import com.examen.back2.services.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ControladorCliente {

    @Autowired
    private ServicioCliente servicio;

    @GetMapping
    public org.springframework.http.ResponseEntity<List<ClienteDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/{id}")
    public org.springframework.http.ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public org.springframework.http.ResponseEntity<?> guardar(@RequestBody ClienteDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping("/{id}")
    public org.springframework.http.ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody ClienteDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
