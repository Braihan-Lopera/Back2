package com.examen.back2.controller;

import com.examen.back2.DTO.RolDTO;
import com.examen.back2.services.ServicioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/roles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControladorRol {

    @Autowired
    private ServicioRol servicio;

    @GetMapping("/todos")
    public ResponseEntity<List<RolDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping(value = "/guardar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardar(@RequestBody RolDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping(value = "/modificar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody RolDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
