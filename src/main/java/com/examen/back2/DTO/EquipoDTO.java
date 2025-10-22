package com.examen.back2.DTO;
import com.examen.back2.models.Cliente;
import com.examen.back2.models.Tecnico;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EquipoDTO {
    private Integer id;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private Cliente cliente;
    private Tecnico tecnico;
}
