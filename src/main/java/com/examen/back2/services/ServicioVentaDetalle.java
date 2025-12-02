package com.examen.back2.services;

import com.examen.back2.DTO.VentaDetalleDTO;
import com.examen.back2.maps.MapaVentaDetalle;
import com.examen.back2.models.VentaDetalle;
import com.examen.back2.repository.RepositorioVentaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioVentaDetalle {

    @Autowired
    private RepositorioVentaDetalle repositorio;

    @Autowired
    private MapaVentaDetalle mapa;

    public org.springframework.http.ResponseEntity<List<VentaDetalleDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<VentaDetalle> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.ventaDetalleToVentaDetalleDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Detalle de venta no encontrado");
    }

    public org.springframework.http.ResponseEntity<?> guardar(VentaDetalleDTO dto) {
        try {
            VentaDetalle entity = mapa.ventaDetalleDTOToVentaDetalle(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.ventaDetalleToVentaDetalleDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar el detalle de venta");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, VentaDetalleDTO dto) {
        if (repositorio.existsById(id)) {
            VentaDetalle entity = mapa.ventaDetalleDTOToVentaDetalle(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.ventaDetalleToVentaDetalleDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Detalle de venta no encontrado para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Detalle de venta eliminado correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Detalle de venta no encontrado para eliminar");
    }
}
