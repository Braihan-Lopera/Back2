package com.examen.back2.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userName", nullable = false, unique = true, length = 20)
    private String userName;
    @Column(name = "contraseña", nullable = false, unique = false, length = 20)
    private String contraseña;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles;
    
    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference(value = "relacionusuariotoken")
    private Set<Token> tokens;
}
