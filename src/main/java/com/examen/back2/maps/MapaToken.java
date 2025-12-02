package com.examen.back2.maps;

import com.examen.back2.DTO.TokenDTO;
import com.examen.back2.models.Token;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaToken {
    TokenDTO tokenToTokenDTO(Token token);
    List<TokenDTO> listaToListDTO(List<Token> lista);

    @InheritInverseConfiguration
    Token tokenDTOToToken(TokenDTO tokenDTO);
}
