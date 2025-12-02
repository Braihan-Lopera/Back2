package com.examen.back2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "VentaDetalle")
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cantidad", nullable = false, unique = false)
    private Integer cantidad;
    @Column(name ="precioUnitario", nullable = false, unique = false)
    private float precioUnitario;


    @ManyToOne
    @JoinColumn(name = "fk_producto")
    @JsonBackReference(value = "relacionproductoventadetalle")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "fk_factura")
    @JsonBackReference(value = "relacionfacturaventadetalle")
    private Factura factura;

}
