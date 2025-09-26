package com.MottuChallenge_Java.gef.service;


import com.MottuChallenge_Java.gef.model.Usuario;
import com.MottuChallenge_Java.gef.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // CRUD -> Create, Read, Update, Delete
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario readUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> readUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
