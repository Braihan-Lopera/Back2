package com.examen.back2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="Permisos")
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="tipoPermiso", nullable = false, unique = true)
    private String tipoPermiso;

    @ManyToMany
    @JsonManagedReference(value = "relacionpermisorol")
}
