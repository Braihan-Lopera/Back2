package com.examen.back2.maps;

import com.examen.back2.models.Registro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapaRegistro {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "problema", target = "problema")
    @Mapping(source = "solucion", target = "solucion")
    @Mapping(source = "fechaIngreso", target = "fechaIngreso")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "tecnico", target = "tecnico")
    @Mapping(source = "equipo", target = "equipo")
    @Mapping(source = "factura", target = "factura")
    Registro RegistroToRegistroDTO(Registro registro);
}
