package com.examen.back2.models;
import jakarta.persistence.*;

@Entity
@Table (name ="Usuario")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userName", nullable = false, unique = true, length = 20)
    private String userName;
    @Column(name = "contraseña", nullable = false, unique = false, length = 20)
    private String contraseña;
    @Column (name = "hash", nullable = false, unique = false)
    private String hash;
    @Column (name ="email", nullable = false, unique = true)
    private String email;
}
