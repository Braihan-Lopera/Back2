package com.examen.back2.maps;

import com.examen.back2.DTO.ClienteDTO;
import com.examen.back2.models.Cliente;
import com.examen.back2.models.Registro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaCliente {
    ClienteDTO clienteToClienteDTO(Cliente cliente);
    List<ClienteDTO> listaToListDTO(List<Cliente> lista);

}
