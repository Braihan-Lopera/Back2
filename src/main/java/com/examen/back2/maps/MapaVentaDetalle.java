package com.examen.back2.maps;

import com.examen.back2.DTO.VentaDetalleDTO;
import com.examen.back2.models.VentaDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaVentaDetalle {
    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "factura.id", target = "facturaId")
    VentaDetalleDTO ventaDetalleToVentaDetalleDTO(VentaDetalle ventaDetalle);
    
    @Mapping(source = "productoId", target = "producto.id")
    @Mapping(source = "facturaId", target = "factura.id")
    VentaDetalle ventaDetalleDTOToVentaDetalle(VentaDetalleDTO dto);
    
    List<VentaDetalleDTO> listaToListDTO(List<VentaDetalle> lista);
    List<VentaDetalle> listDTOToLista(List<VentaDetalleDTO> dtos);
}
