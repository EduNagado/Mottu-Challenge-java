package com.MottuChallenge_Java.gef.controller;

import com.MottuChallenge_Java.gef.model.Patio;
import com.MottuChallenge_Java.gef.service.PatioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patios")
public class PatioController {

    @Autowired
    private PatioService patioService;

    @GetMapping("/lista")
    public String listarPatios(Model model) {
        List<Patio> patios = patioService.readPatios();
        model.addAttribute("listaPatios", patios);
        return "patioLista";
    }

    @GetMapping("/cadastro")
    public String cadastroPatio(Model model) {
        model.addAttribute("patio", new Patio());
        return "patioCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarPatio(@Valid Patio patio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("patio", patio);
            return "patioCadastro";
        }
        if (patio.getId() == null) {
            patioService.createPatio(patio);
        } else {
            patioService.updatePatio(patio);
        }
        return "redirect:/patios/lista";
    }

    @GetMapping("/cadastro/{id}")
    public String editarPatio(@PathVariable Long id, Model model) {
        Patio patio = patioService.readPatio(id);
        if (patio == null) {
            return "redirect:/patios/lista";
        }
        model.addAttribute("patio", patio);
        return "patioCadastro";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPatio(@PathVariable Long id) {
        patioService.deletePatio(id);
        return "redirect:/patios/lista";
    }
}
