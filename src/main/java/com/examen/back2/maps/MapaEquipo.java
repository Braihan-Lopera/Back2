package com.examen.back2.maps;

import com.examen.back2.DTO.EquipoDTO;
import com.examen.back2.models.Equipo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaEquipo {
    @Mapping(source = "cliente.id", target = "clienteId")
    EquipoDTO equipoToEquipoDTO(Equipo equipo);
    
    @Mapping(source = "clienteId", target = "cliente.id")
    Equipo equipoDTOToEquipo(EquipoDTO dto);
    
    List<EquipoDTO> listaToListDTO(List<Equipo> lista);
    List<Equipo> listDTOToLista(List<EquipoDTO> dtos);
}
