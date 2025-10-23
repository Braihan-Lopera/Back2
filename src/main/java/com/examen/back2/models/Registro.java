package com.examen.back2.models;
import com.examen.back2.assistance.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "problema", nullable = false, unique = false, length = 120)
    private String problema;
    @Column(name = "solucion", nullable = false, unique = false, length = 120)
    private String solucion;
    @Column(name = "fechaIngreso", nullable = false, unique = false, length = 30)
    private LocalDate fechaIngreso;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, unique = false)
    private Estado estado;
    //relacion Equipo-Registro (1-N) lado N
    @ManyToOne
    @JoinColumn(name="fk_equipo")
    @JsonBackReference
    private Equipo equipo;
    //relacion Tecnico-Registro (1-N) lado N
    @ManyToOne
    @JoinColumn(name ="fk_tecnico")
    @JsonBackReference
    private Tecnico tecnico;
    //relacion Registro-Factura (1-1)
    @OneToOne(mappedBy = "registro")
    @JsonManagedReference
    private Factura factura;
}
