package com.examen.back2.DTO;

import com.examen.back2.assistance.Estado;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDTO {
    private Integer id;
    private String problema;
    private String solucion;
    private LocalDate fechaIngreso;
    private Estado estado;
    private Integer equipoId;
    private Integer tecnicoId;
}
