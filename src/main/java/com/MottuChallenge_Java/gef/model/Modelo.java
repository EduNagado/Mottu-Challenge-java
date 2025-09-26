package com.MottuChallenge_Java.gef.model;

public enum Modelo {
    MOTTU_POP("mottu pop"),
    MOTTU_E("mottu e"),
    MOTTU_SPORT("mottu sport");


    private String descricao;

    Modelo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
