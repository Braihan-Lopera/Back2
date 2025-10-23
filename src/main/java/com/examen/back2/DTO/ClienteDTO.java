package com.examen.back2.DTO;
import com.examen.back2.models.Equipo;
import com.examen.back2.models.Registro;
import lombok.*;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nombre;
    private String correo;
    private String numeroCelular;
    private List<Registro> registros;
    private Equipo equipo;
}
