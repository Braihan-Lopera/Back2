package com.examen.back2.controller;

import com.examen.back2.DTO.VentaDetalleDTO;
import com.examen.back2.services.ServicioVentaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ventadetalles", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ControladorVentaDetalle {

    @Autowired
    private ServicioVentaDetalle servicio;

    @GetMapping("/todos")
    public org.springframework.http.ResponseEntity<List<VentaDetalleDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/todos/{id}")
    public org.springframework.http.ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public org.springframework.http.ResponseEntity<?> guardar(@RequestBody VentaDetalleDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping("/modificar/{id}")
    public org.springframework.http.ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody VentaDetalleDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public org.springframework.http.ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
