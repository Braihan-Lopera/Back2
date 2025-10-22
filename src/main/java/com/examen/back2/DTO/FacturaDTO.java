package com.examen.back2.DTO;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacturaDTO {
    private Integer id;
    private LocalDate fechaEmision;
    private String repuestos;
    private String estadoPago;
    private String metodoPago;
    private Float total;
    private RegistroDTO registroDTO;
}
