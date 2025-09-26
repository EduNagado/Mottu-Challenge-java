package com.MottuChallenge_Java.gef.model;

public enum Status {
    DISPONIVEL("Disponivel"),
    RESERVADA("Reservada"),
    ALUGADA("Alugada"),
    EM_MANUTENCAO("Em manutenção"),
    OUTROS("Outros" ) ;
    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
