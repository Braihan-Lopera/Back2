package com.examen.back2.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepuestoDTO {
    private Integer id;
    private String nombre;
    private String numeroSerie;
    private String descripcion;
    private Float precio;
    private Integer stock;
}
