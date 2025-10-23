package com.examen.back2.services;
import com.examen.back2.DTO.ClienteDTO;
import com.examen.back2.maps.MapaCliente;
import com.examen.back2.models.Cliente;
import com.examen.back2.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCliente {
    @Autowired
    private RepositorioCliente repositorio;

    @Autowired
    private MapaCliente mapa;
}
