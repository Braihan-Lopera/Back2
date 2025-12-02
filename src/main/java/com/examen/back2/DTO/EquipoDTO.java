package com.examen.back2.DTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoDTO {
    private Integer id;
    private String marca;
    private String modelo;
    private String tipo;
    private String numeroSerie;
    private Integer clienteId;
}
