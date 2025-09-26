package com.MottuChallenge_Java.gef.controller;

import com.MottuChallenge_Java.gef.model.Modelo;
import com.MottuChallenge_Java.gef.model.Moto;
import com.MottuChallenge_Java.gef.model.Status;
import com.MottuChallenge_Java.gef.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping("/lista")
    public String listarMotos(Model model) {
        List<Moto> motos = motoService.readMotos();
        model.addAttribute("listaMotos", motos);
        return "motoLista";
    }

    @GetMapping("/cadastro")
    public String cadastroMoto(Model model) {
        model.addAttribute("moto", new Moto());
        model.addAttribute("modeloLista", Arrays.asList(Modelo.values()));
        model.addAttribute("statusLista", Arrays.asList(Status.values()));
        return "motoCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarMoto(@Valid Moto moto, BindingResult result, Model model) {
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
        return listarMotos(model);
    }

    @GetMapping("/cadastro/{id}")
    public String editarMoto(@PathVariable Long id, Model model) {
        Moto moto = motoService.readMoto(id);
        if (moto == null) {
            return listarMotos(model);
        }
        model.addAttribute("moto", moto);
        model.addAttribute("modeloLista", Arrays.asList(Modelo.values()));
        model.addAttribute("statusLista", Arrays.asList(Status.values()));
        return "motoCadastro";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMoto(@PathVariable Long id, Model model) {
        motoService.deleteMoto(id);
        return listarMotos(model);
    }
}