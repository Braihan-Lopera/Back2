package com.examen.back2.maps;

import com.examen.back2.DTO.TecnicoDTO;
import com.examen.back2.models.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapaTecnico {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "celular", target = "celular")
    @Mapping(source = "cargo", target = "cargo")
    @Mapping(source = "registro", target = "registro")
    @Mapping(source = "equipo", target = "equipo")
    TecnicoDTO TecnicoToTecnicoDTO(Tecnico tecnico);
}
