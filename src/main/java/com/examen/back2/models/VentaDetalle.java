package com.examen.back2.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

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
    private Producto producto;

    @ManyToOne
    @JoinColumn(name ="fk_factura")
    private Factura factura;

}
