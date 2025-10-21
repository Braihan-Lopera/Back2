package com.examen.back2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
