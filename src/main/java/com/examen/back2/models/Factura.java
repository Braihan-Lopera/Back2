package com.examen.back2.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Factura")
public class Factura {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name="fechaEmision", nullable = false, unique = false, length = 30)
    private LocalDate fechaEmision;
    @Column (name="repuestos", nullable = false, unique = false, length = 30)
    private String repuestos;
    @Column (name="estadoPago", nullable = false, unique = false, length = 30)
    private String estadoPago;
    @Column (name="metodoPago", nullable = false, unique = false, length = 30)
    private String metodoPago;
    @Column (name="total", nullable = false, unique = false, length = 30)
    private Float total;

    //claves foraneas;
    @OneToOne
    @JoinColumn (name = "registro_id", nullable = false)
    private Registro registro;

}
