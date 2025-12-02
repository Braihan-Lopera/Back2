package com.examen.back2.maps;

import com.examen.back2.DTO.TecnicoDTO;
import com.examen.back2.models.Tecnico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaTecnico {
    TecnicoDTO tecnicoToTecnicoDTO(Tecnico tecnico);
    Tecnico tecnicoDTOToTecnico(TecnicoDTO dto);
    List<TecnicoDTO> listaToListDTO(List<Tecnico> lista);
    List<Tecnico> listDTOToLista(List<TecnicoDTO> dtos);
}
