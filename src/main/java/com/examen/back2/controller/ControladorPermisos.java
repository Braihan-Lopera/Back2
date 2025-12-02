package com.examen.back2.controller;

import com.examen.back2.DTO.PermisosDTO;
import com.examen.back2.services.ServicioPermisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/permisos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ControladorPermisos {

    @Autowired
    private ServicioPermisos servicio;

    @GetMapping("/todos")
    public org.springframework.http.ResponseEntity<List<PermisosDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/todos/{id}")
    public org.springframework.http.ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public org.springframework.http.ResponseEntity<?> guardar(@RequestBody PermisosDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping("/modificar/{id}")
    public org.springframework.http.ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody PermisosDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public org.springframework.http.ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
