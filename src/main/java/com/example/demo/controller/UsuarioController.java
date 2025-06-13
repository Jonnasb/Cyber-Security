package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.dto.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import jakarta.validation.Valid;
import org.hibernate.mapping.Map;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public ResponseEntity<UsuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());

    }
    @PostMapping
    public ResponseEntity<Map<Object , String>> salvar(@Valid @RequestBody UsuarioDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity
                .status(GraphQlProperties.HttpStatus.CREATED)
                .body(Map"mensagens", "Usuario cadastrar com sucesso"))
    }
}
