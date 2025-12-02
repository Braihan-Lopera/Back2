package com.examen.back2.maps;

import com.examen.back2.DTO.ProductoDTO;
import com.examen.back2.models.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaProducto {
    ProductoDTO productoToProductoDTO(Producto producto);
    List<ProductoDTO> listaToListDTO(List<Producto> lista);

    @InheritInverseConfiguration
    Producto productoDTOToProducto(ProductoDTO productoDTO);
}
