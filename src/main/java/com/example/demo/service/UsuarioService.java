package com.example.demo.service;


import com.example.demo.dto.UsuarioDTO;
import com.example.demo.dto.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public usuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public Usuario salvarUsuario(UsuarioDTO dto) {
        usuarioRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> { throw new IllegalAccessException("E-mail já cadastrado."); });

            Usuario usuario = new Usuario();
            usuario.setNome(dto.getNome());
            usuario.setEmail(dto.getEmail());
            usuario.setSenha(bCryptPasswordEncoder.encode((dto.getSenha)));

            return usuarioRepository.save(usuario);
    }

    public List<UsuarioResponseDTO>listarTodosUsuarios(){
        return  usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

    }
    private  UsuarioResponseDTO toDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getNome(), usuario.getEmail());

    }
}



