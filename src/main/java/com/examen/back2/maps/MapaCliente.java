package com.examen.back2.maps;

import com.examen.back2.DTO.ClienteDTO;
import com.examen.back2.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaCliente {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "numeroCelular", target = "numeroCelular")
    @Mapping(source = "registro", target = "registro")
    @Mapping(source = "equipo", target = "equipo")
    ClienteDTO ClienteToClienteDTO(Cliente cliente);


    @Mapping(source = "", target = "")
    List<Cliente> ListaToListDTO(List<Cliente> lista);

}
