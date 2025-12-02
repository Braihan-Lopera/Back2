package com.examen.back2.services;

import com.examen.back2.DTO.FacturaDTO;
import com.examen.back2.maps.MapaFactura;
import com.examen.back2.models.Factura;
import com.examen.back2.repository.RepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioFactura {

    @Autowired
    private RepositorioFactura repositorio;

    @Autowired
    private MapaFactura mapa;

    public org.springframework.http.ResponseEntity<List<FacturaDTO>> buscarTodos() {
        return org.springframework.http.ResponseEntity.ok(mapa.listaToListDTO(repositorio.findAll()));
    }

    public org.springframework.http.ResponseEntity<?> buscarPorId(Integer id) {
        Optional<Factura> entity = repositorio.findById(id);
        if (entity.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(mapa.facturaToFacturaDTO(entity.get()));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Factura no encontrada");
    }

    public org.springframework.http.ResponseEntity<?> guardar(FacturaDTO dto) {
        try {
            Factura entity = mapa.facturaDTOToFactura(dto);
            return org.springframework.http.ResponseEntity.ok(mapa.facturaToFacturaDTO(repositorio.save(entity)));
        } catch (Exception e) {
            return org.springframework.http.ResponseEntity.badRequest().body("Error al guardar la factura");
        }
    }

    public org.springframework.http.ResponseEntity<?> modificar(Integer id, FacturaDTO dto) {
        if (repositorio.existsById(id)) {
            Factura entity = mapa.facturaDTOToFactura(dto);
            entity.setId(id);
            return org.springframework.http.ResponseEntity.ok(mapa.facturaToFacturaDTO(repositorio.save(entity)));
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Factura no encontrada para modificar");
    }

    public org.springframework.http.ResponseEntity<?> eliminar(Integer id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.ok("Factura eliminada correctamente");
        }
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body("Factura no encontrada para eliminar");
    }
}
