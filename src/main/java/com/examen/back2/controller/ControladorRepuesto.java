package com.examen.back2.controller;

import com.examen.back2.DTO.RepuestoDTO;
import com.examen.back2.services.ServicioRepuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/repuestos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControladorRepuesto {

    @Autowired
    private ServicioRepuesto servicio;

    @GetMapping("/todos")
    public ResponseEntity<List<RepuestoDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping(value = "/guardar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardar(@RequestBody RepuestoDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping(value = "/modificar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody RepuestoDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
