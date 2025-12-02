package com.examen.back2.services;

import com.examen.back2.DTO.ProductoDTO;
import com.examen.back2.maps.MapaProducto;
import com.examen.back2.models.Producto;
import com.examen.back2.repository.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProducto {

    @Autowired
    private RepositorioProducto repositorio;

    @Autowired
    private MapaProducto mapa;

    public org.springframework.http.ResponseEntity<List<ProductoDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Producto> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.productoToProductoDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(ProductoDTO dto) {
        try {
            Producto entity = mapa.productoDTOToProducto(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.productoToProductoDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el producto");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, ProductoDTO dto) {
        if (repositorio.existsById(id)) {
            Producto entity = mapa.productoDTOToProducto(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.productoToProductoDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Producto no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Producto eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Producto no encontrado para eliminar");
    }
}
