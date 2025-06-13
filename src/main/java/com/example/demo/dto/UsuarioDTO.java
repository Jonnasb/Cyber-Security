package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "deve ser um e-mail válido.")
    private  String email;

    @NotBlank(message = "A senha é obrigatória.")
    private String senha;

    public UsuarioDTO() {
        
    }

    public UsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank UsuarioDTO(message = "O nome é obrigatório")
        return nome;

}
