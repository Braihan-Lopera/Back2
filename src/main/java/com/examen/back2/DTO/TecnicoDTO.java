package com.examen.back2.DTO;

import com.examen.back2.models.Equipo;
import com.examen.back2.models.Registro;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TecnicoDTO {
    private String nombre;
    private String correo;
    private String celular;
    private String cargo;
    private List<Registro> registros;
    private Equipo equipo;
}
