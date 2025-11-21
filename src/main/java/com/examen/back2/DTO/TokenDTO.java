package com.examen.back2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private Integer id;
    private String token;
    private LocalDateTime fechaExpiracion;
    private Boolean activo;
    private Integer usuarioId;
}
