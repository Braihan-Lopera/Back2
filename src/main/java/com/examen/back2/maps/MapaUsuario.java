package com.examen.back2.maps;

import com.examen.back2.DTO.UsuarioDTO;
import com.examen.back2.models.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaUsuario {
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    List<UsuarioDTO> listaToListDTO(List<Usuario> lista);

    @InheritInverseConfiguration
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
}
