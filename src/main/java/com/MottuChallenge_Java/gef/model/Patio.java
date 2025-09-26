package com.MottuChallenge_Java.gef.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Patio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A localização do pátio é obrigatória.")
    private String localizacao;

    @NotNull(message = "A quantidade de vagas no pátio é obrigatória.")
    @PositiveOrZero(message = "A quantidade de vagas não pode ser negativa.")
    private Integer quantidadeVagas;

    @ManyToOne
    @JoinColumn(name = "cadastro_por")
    private Usuario cadastroPor;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Moto> motos = new ArrayList<>();

    public Long getIdPatio() {
        return id;
    }

    public Long getId() {
        return id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(Integer quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }
}
