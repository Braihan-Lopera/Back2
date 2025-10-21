package com.examen.back2.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Registro")
public class Registro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name="problema", nullable = false, unique = false, length = 120)
    private String problema;
    @Column (name="solucion", nullable = false, unique = false, length = 120)
    private String solucion;
    @Column (name="fechaIngreso", nullable = false, unique = false, length = 30)
    private LocalDate fechaIngreso;

    //Claves foraneas; relacion uno a muchos.
    @ManyToOne
    @JoinColumn (name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn (name = "tecnico_id", nullable = false)
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn (name ="equipo_id", nullable = false)
    private Equipo equipo;

}
