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
@Table(name = "Tecnico")
public class Tecnico {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name="nombre", nullable = false, unique = false, length = 50)
    private String nombre;
    @Column (name="correo", nullable = false, unique = true, length = 30)
    private String correo;
    @Column (name="documento", nullable = false, unique = true, length = 10)
    private String documento;
    @Column (name="celular", nullable = false, unique = true, length = 12)
    private String celular;
    @Column (name="cargo", nullable = false, unique = false, length = 10)
    private String cargo;

    //relacion Tecnico_Registro (1-N) lado 1
    @OneToMany(mappedBy = "tecnico")
    @JsonManagedReference (value ="relaciontecnicoregistro")
    private List<Registro>registros;
}
