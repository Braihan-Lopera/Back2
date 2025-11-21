package com.examen.back2.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalleDTO {
    private Integer id;
    private String cantidad;
    private float preciounitario;
    private Integer producto;
    private Integer factura;
}
