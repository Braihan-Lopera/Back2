package com.examen.back2.DTO;

import com.examen.back2.assistance.Estado;
import com.examen.back2.models.Cliente;
import com.examen.back2.models.Equipo;
import com.examen.back2.models.Factura;
import com.examen.back2.models.Tecnico;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistroDTO {
    private Integer id;
    private String problema;
    private String solucion;
    private LocalDate fechaIngreso;
    private Estado estado;
    private Cliente cliente;
    private Tecnico tecnico;
    private Equipo equipo;
    private Factura factura;
}
