package com.examen.back2.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Equipo")
public class Equipo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name="marca", nullable = false, unique = false, length = 30)
    private String marca;
    @Column (name="modelo", nullable = false, unique = false, length = 30)
    private String modelo;
    @Column (name="tipo", nullable = false, unique = false, length = 30)
    private String tipo;
    @Column (name="numeroSerie", nullable = false, unique = true, length = 30)
    private String numeroSerie;
    //relacion Equipo-Registro (1-M) lado 1
    private List<Registro>registros;
    //relacion Equipo-Cliente (N-1)
    @ManyToOne
    @JoinColumn(name ="fk_cliente", referencedColumnName = "id")
    private Cliente cliente;
    //Relacion Equipo_Tecnico (M-1)
    @ManyToOne
    @JoinColumn(name = "fk_tecnico", referencedColumnName = "id")
    @JsonManagedReference(value ="relacionequipotecnico")
    private Tecnico tecnico;
}
