package com.MottuChallenge_Java.gef.model;

import com.MottuChallenge_Java.gef.validation.AnoValido;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O modelo é obrigatório")
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    @NotBlank(message = "A placa da moto é obrigatória.")
    private String placa;

    @AnoValido(message = "O ano deve ser entre 1000 e o próximo ano")
    @NotNull(message = "O ano da moto é obrigatório.")
    private Integer ano;

    @NotBlank(message = "A cor da moto é obrigatória.")
    private String cor;

    @NotNull(message = "A disponibilidade é obrigatória")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "patio_id")
    private Patio patio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
