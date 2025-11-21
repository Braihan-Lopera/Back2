package com.examen.back2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name ="Token")
public class Token{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Token", nullable = false)
    private String Token;

    @ManyToOne
    @JoinColumn(name ="fk_Usuario")
    @JsonBackReference(value = "relaciontokenusuario")
    private Usuario usuario;
}
