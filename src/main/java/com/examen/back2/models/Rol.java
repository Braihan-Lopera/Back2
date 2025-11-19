package com.examen.back2.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre del rol, ej: ROLE_ADMIN, ROLE_TECNICO, ROLE_CLIENTE
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "rol_permisos",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "permiso_id")
    )
    @JsonManagedReference(value = "relacionpermisorol")
    private Set<Permisos> permisos;
    
}