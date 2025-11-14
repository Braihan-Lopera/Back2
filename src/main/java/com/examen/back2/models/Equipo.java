package com.examen.back2.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
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
    //relacion Cliente-Equipo(1-N) lado N
    @ManyToOne
    @JoinColumn(name="fk_cliente")
    @JsonBackReference(value = "relacionequipocliente")
    private Cliente cliente;
    //relacion Equipo-Registro (1-N) lado 1
    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference (value ="relacionequiporegistro")
    private List<Registro> registros;
}
