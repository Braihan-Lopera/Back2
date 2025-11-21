package com.examen.back2.DTO;

import com.examen.back2.models.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermisosDTO {
    private Integer id;
    private String tipoPermiso;
}
