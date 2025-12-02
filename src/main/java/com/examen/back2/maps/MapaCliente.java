package com.examen.back2.maps;

import com.examen.back2.DTO.ClienteDTO;
import com.examen.back2.models.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaCliente {
    ClienteDTO clienteToClienteDTO(Cliente cliente);
    Cliente clienteDTOToCliente(ClienteDTO dto);
    List<ClienteDTO> listaToListDTO(List<Cliente> lista);
    List<Cliente> listDTOToLista(List<ClienteDTO> dtos);
}
