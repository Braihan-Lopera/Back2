package com.examen.back2.DTO;


import com.examen.back2.models.Rol;
import com.examen.back2.models.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String userName;
    private String email;
    private List<Rol>roles;
}
