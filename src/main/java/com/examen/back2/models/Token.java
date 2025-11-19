package com.examen.back2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name ="Token")
public class Token{
    private Integer id;
    private String Token;

    @ManyToOne
    @JoinColumn(name ="fk_Usuario")
    @JsonBackReference(value = "relaciontokenusuario")
    private Usuario usuario;
}
