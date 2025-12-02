package com.examen.back2.maps;

import com.examen.back2.DTO.VentaDetalleDTO;
import com.examen.back2.models.VentaDetalle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaVentaDetalle {
    VentaDetalleDTO ventaDetalleToVentaDetalleDTO(VentaDetalle ventaDetalle);
    List<VentaDetalleDTO> listaToListDTO(List<VentaDetalle> lista);

    @InheritInverseConfiguration
    VentaDetalle ventaDetalleDTOToVentaDetalle(VentaDetalleDTO ventaDetalleDTO);
}
