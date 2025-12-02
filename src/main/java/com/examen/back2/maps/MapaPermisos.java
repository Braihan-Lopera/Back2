package com.examen.back2.maps;

import com.examen.back2.DTO.PermisosDTO;
import com.examen.back2.models.Permisos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaPermisos {
    PermisosDTO permisosToPermisosDTO(Permisos permisos);
    List<PermisosDTO> listaToListDTO(List<Permisos> lista);
    
    @InheritInverseConfiguration
    Permisos permisosDTOToPermisos(PermisosDTO permisosDTO);
}
