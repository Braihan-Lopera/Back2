package com.examen.back2.maps;
import com.examen.back2.DTO.FacturaDTO;
import com.examen.back2.models.Factura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapaFactura {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "fechaEmision", target = "fechaEmision")
    @Mapping(source = "repuestos", target = "repuestos")
    @Mapping(source = "estadoPago", target = "estadoPago")
    @Mapping(source = "metodoPago", target = "metodoPago")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "registroDTO", target = "registroDTO")
    FacturaDTO FacturaToFacturaDTO(Factura factura);
}
