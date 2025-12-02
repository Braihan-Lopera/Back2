package com.examen.back2.DTO;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String correo;
    private String documento;
    private String numeroCelular;
}
