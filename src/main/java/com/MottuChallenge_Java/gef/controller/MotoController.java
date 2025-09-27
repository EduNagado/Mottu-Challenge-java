package com.MottuChallenge_Java.gef.controller;

import com.MottuChallenge_Java.gef.model.Modelo;
import com.MottuChallenge_Java.gef.model.Moto;
import com.MottuChallenge_Java.gef.model.Status;
import com.MottuChallenge_Java.gef.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/motos")
public class MotoController extends BaseController {

    @Autowired
    private MotoService motoService;

    @GetMapping("/lista")
    public String listarMotos(@AuthenticationPrincipal OAuth2User principal, Model model) {
        addUserToModel(principal, model);
        List<Moto> motos = motoService.readMotos();
        model.addAttribute("listaMotos", motos);
        return "motoLista";
    }

    @GetMapping("/cadastro")
    public String cadastroMoto(@AuthenticationPrincipal OAuth2User principal, Model model) {
        addUserToModel(principal, model);
        model.addAttribute("moto", new Moto());
        model.addAttribute("modeloLista", Arrays.asList(Modelo.values()));
        model.addAttribute("statusLista", Arrays.asList(Status.values()));
        return "motoCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarMoto(@AuthenticationPrincipal OAuth2User principal,
                                @Valid Moto moto, BindingResult result, Model model) {
        addUserToModel(principal, model);

        if (result.hasErrors()) {
            model.addAttribute("moto", moto);
            model.addAttribute("modeloLista", Arrays.asList(Modelo.values()));
            model.addAttribute("statusLista", Arrays.asList(Status.values()));
            return "motoCadastro";
        }

        if (moto.getId() == null) {
            motoService.createMoto(moto);
        } else {
            motoService.updateMoto(moto);
        }
        return "redirect:/motos/lista";
    }

    @GetMapping("/cadastro/{id}")
    public String editarMoto(@AuthenticationPrincipal OAuth2User principal,
                             @PathVariable Long id, Model model) {
        addUserToModel(principal, model);
        Moto moto = motoService.readMoto(id);
        if (moto == null) {
            return "redirect:/motos/lista";
        }
        model.addAttribute("moto", moto);
        model.addAttribute("modeloLista", Arrays.asList(Modelo.values()));
        model.addAttribute("statusLista", Arrays.asList(Status.values()));
        return "motoCadastro";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMoto(@AuthenticationPrincipal OAuth2User principal,
                              @PathVariable Long id, Model model) {
        addUserToModel(principal, model);
        motoService.deleteMoto(id);
        return "redirect:/motos/lista";
    }
}
