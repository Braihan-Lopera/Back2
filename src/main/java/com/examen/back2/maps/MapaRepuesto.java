package com.examen.back2.maps;

import com.examen.back2.DTO.RepuestoDTO;
import com.examen.back2.models.Repuesto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaRepuesto {
    RepuestoDTO repuestoToRepuestoDTO(Repuesto repuesto);
    List<RepuestoDTO> listaToListDTO(List<Repuesto> lista);

    @InheritInverseConfiguration
    Repuesto repuestoDTOToRepuesto(RepuestoDTO repuestoDTO);
}
