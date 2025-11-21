package com.examen.back2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, unique = false, length = 30)
    private String nombre;
    @Column(name = "numeroSerie", nullable = false, unique = true, length = 100)
    private String numeroSerie; //diferente al id porque el id es el identificador dentro del taller
    @Column(name = "descripcion", nullable = false, unique = false, length = 120)
    private String descripcion;
    @Column(name = "precio", nullable = false, unique = false)
    private float precio;
    @Column(name = "stock", nullable = false, unique = false)
    private Integer stock;

    @OneToMany (mappedBy = "producto")
    @JsonManagedReference(value ="relacionproductoventadetalle")
    private VentaDetalle ventaDetalle;
}
