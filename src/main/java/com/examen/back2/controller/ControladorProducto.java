package com.examen.back2.controller;

import com.examen.back2.DTO.ProductoDTO;
import com.examen.back2.services.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/productos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControladorProducto {

    @Autowired
    private ServicioProducto servicio;

    @GetMapping("/todos")
    public ResponseEntity<List<ProductoDTO>> buscarTodos() {
        return servicio.buscarTodos();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping(value = "/guardar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardar(@RequestBody ProductoDTO dto) {
        return servicio.guardar(dto);
    }

    @PutMapping(value = "/modificar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody ProductoDTO dto) {
        return servicio.modificar(id, dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return servicio.eliminar(id);
    }
}
