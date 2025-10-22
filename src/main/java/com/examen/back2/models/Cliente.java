package com.examen.back2.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre", nullable = false, unique = false, length = 50)
    private String nombre;
    @Column(name="correo", nullable = false, unique = true, length = 50)
    private String correo;
    @Column(name="Documento", nullable = false, unique = true, length = 10)
    private String Documento;
    @Column(name="numeroCelular", nullable = false, unique = true, length = 12)
    private String numeroCelular;
    //relacion Cliente-Registro (1-M) lado 1
    private List<Registro> registros;
    //relacion Cliente-Equipo (1-M)
    @OneToMany (mappedBy = "cliente")
    private Equipo equipo;
}
