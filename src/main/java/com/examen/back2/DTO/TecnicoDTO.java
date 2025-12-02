package com.examen.back2.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoDTO {
    private Integer id;
    private String nombre;
    private String correo;
    private String documento;
    private String celular;
    private String cargo;
}
