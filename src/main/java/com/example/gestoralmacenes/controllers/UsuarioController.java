package com.example.gestoralmacenes.controllers;

import com.example.gestoralmacenes.models.personas.Usuario;
import com.example.gestoralmacenes.repositories.UsuarioRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/usuario/create")
    public void createUsuario(Usuario usuario)
    {
        repository.save(usuario);
    }

    @PostMapping(value = "ver")
    public String holamundo()
    {
        return "Hola mundo";
    }
}
