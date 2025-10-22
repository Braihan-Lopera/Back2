package com.examen.back2.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    //claves foraneas; relacion 1-1
    @OneToOne
    @JoinColumn (name = "fk_registro", referencedColumnName = "id")
    @JsonManagedReference(value = "relacionfacturaregistro")
    private Registro registro;
}
