package com.MottuChallenge_Java.gef.model;

public enum Cargo {
    ADMINISTRADOR ("Administrador"),
    GERENTE("Gerente"),
    ATENDENTE("Atendente"),
    MECANICO ("Mecanico"),
    AUXILIAR("Auxiliar"),
    ENTREGADOR("Entregador");

    private String descricao;

    Cargo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
