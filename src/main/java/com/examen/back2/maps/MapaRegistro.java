package com.examen.back2.maps;

import com.examen.back2.DTO.RegistroDTO;
import com.examen.back2.models.Registro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaRegistro {
    @Mapping(source = "equipo.id", target = "equipoId")
    @Mapping(source = "tecnico.id", target = "tecnicoId")
    RegistroDTO registroToRegistroDTO(Registro registro);
    
    @Mapping(source = "equipoId", target = "equipo.id")
    @Mapping(source = "tecnicoId", target = "tecnico.id")
    Registro registroDTOToRegistro(RegistroDTO dto);
    
    List<RegistroDTO> listaToListDTO(List<Registro> lista);
    List<Registro> listDTOToLista(List<RegistroDTO> dtos);
}
