package com.examen.back2.maps;
import com.examen.back2.DTO.FacturaDTO;
import com.examen.back2.models.Factura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaFactura {
    @Mapping(source = "registro.id", target = "registroId")
    FacturaDTO facturaToFacturaDTO(Factura factura);
    
    @Mapping(source = "registroId", target = "registro.id")
    Factura facturaDTOToFactura(FacturaDTO dto);
    
    List<FacturaDTO> listaToListDTO(List<Factura> lista);
    List<Factura> listDTOToLista(List<FacturaDTO> dtos);
}
