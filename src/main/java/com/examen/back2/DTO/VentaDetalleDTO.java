package com.examen.back2.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalleDTO {
    private Integer id;
    private Integer cantidad;
    private Float precioUnitario;
    private Integer productoId;
    private Integer facturaId;
}
