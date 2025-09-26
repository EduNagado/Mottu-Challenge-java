package com.MottuChallenge_Java.gef.controller;


import com.MottuChallenge_Java.gef.model.Cargo;
import com.MottuChallenge_Java.gef.model.Usuario;
import com.MottuChallenge_Java.gef.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.readUsuarios());
        return "usuarioLista";
    }

    @GetMapping("/cadastro")
    public String cadastroUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("cargoLista", Arrays.asList(Cargo.values()));
        return "usuarioCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@Valid Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("cargoLista", Arrays.asList(Cargo.values()));
            return "usuarioCadastro";
        }
        if (usuario.getId() == null) {
            usuarioService.createUsuario(usuario);
        } else {
            usuarioService.updateUsuario(usuario);
        }
        return listarUsuarios(model);
    }

    @GetMapping("/cadastro/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.readUsuario(id);
        if (usuario == null) {
            return listarUsuarios(model);
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("cargoLista", Arrays.asList(Cargo.values()));
        return "usuarioCadastro";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id, Model model) {
        usuarioService.deleteUsuario(id);
        return listarUsuarios(model);
    }
}