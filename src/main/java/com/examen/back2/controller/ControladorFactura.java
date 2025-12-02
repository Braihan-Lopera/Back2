package com.examen.back2.controller;

import com.examen.back2.DTO.FacturaDTO;
import com.examen.back2.services.ServicioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/facturas", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ControladorFactura {

    @Autowired
    private ServicioFactura servicio;

    @GetMapping("/todos")
    public org.springframework.http.ResponseEntity<List<FacturaDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/todos/{id}")
    public org.springframework.http.ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public org.springframework.http.ResponseEntity<?> guardar(@RequestBody FacturaDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping("/modificar/{id}")
    public org.springframework.http.ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody FacturaDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public org.springframework.http.ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
