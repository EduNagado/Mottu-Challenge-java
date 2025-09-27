package com.MottuChallenge_Java.gef.controller;

import com.MottuChallenge_Java.gef.model.Patio;
import com.MottuChallenge_Java.gef.service.PatioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patios")
public class PatioController extends BaseController {

    @Autowired
    private PatioService patioService;

    @GetMapping("/lista")
    public String listarPatios(@AuthenticationPrincipal OAuth2User principal, Model model) {
        addUserToModel(principal, model);
        List<Patio> patios = patioService.readPatios();
        model.addAttribute("listaPatios", patios);
        return "patioLista";
    }

    @GetMapping("/cadastro")
    public String cadastroPatio(@AuthenticationPrincipal OAuth2User principal, Model model) {
        addUserToModel(principal, model);
        model.addAttribute("patio", new Patio());
        return "patioCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarPatio(@AuthenticationPrincipal OAuth2User principal,
                                 @Valid Patio patio, BindingResult result, Model model) {
        addUserToModel(principal, model);

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
    public String editarPatio(@AuthenticationPrincipal OAuth2User principal,
                              @PathVariable Long id, Model model) {
        addUserToModel(principal, model);
        Patio patio = patioService.readPatio(id);
        if (patio == null) {
            return "redirect:/patios/lista";
        }
        model.addAttribute("patio", patio);
        return "patioCadastro";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPatio(@AuthenticationPrincipal OAuth2User principal,
                               @PathVariable Long id, Model model) {
        addUserToModel(principal, model);
        patioService.deletePatio(id);
        return "redirect:/patios/lista";
    }
}
