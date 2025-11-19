package com.examen.back2.maps;

import com.examen.back2.DTO.RolDTO;
import com.examen.back2.models.Rol;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaRol {
    RolDTO rolTorolDTO(Rol rol);
    List<RolDTO>listToListDTO(List<Rol> lista);
}
