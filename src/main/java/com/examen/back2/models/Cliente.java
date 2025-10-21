package com.examen.back2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    //Relaciones:

}
