package com.examen.back2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "permisos")
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipoPermiso", nullable = false, unique = true)
    private String tipoPermiso;

    @ManyToMany(mappedBy = "permisos")
    @JsonBackReference(value = "relacionpermisorol")
    private Set<Rol> roles;
}
