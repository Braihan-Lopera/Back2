package com.examen.back2.maps;

import com.examen.back2.DTO.EquipoDTO;
import com.examen.back2.models.Equipo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapaEquipo {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "marca", target = "marca")
    @Mapping(source = "modelo", target = "modelo")
    @Mapping(source = "numeroSerie", target = "numeroSerie")
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "tecnico", target = "tecnico")
    EquipoDTO EquipoToEquipoDTO(Equipo equipo);

}
