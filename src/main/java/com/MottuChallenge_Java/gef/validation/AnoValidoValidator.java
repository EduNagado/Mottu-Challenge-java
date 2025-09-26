package com.MottuChallenge_Java.gef.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class AnoValidoValidator implements ConstraintValidator<AnoValido, Integer> {

    private int anoMinimo;
    private int margemFutura;

    @Override
    public void initialize(AnoValido constraintAnnotation) {
        this.anoMinimo = constraintAnnotation.anoMinimo();
        this.margemFutura = constraintAnnotation.margemFutura();
    }

    @Override
    public boolean isValid(Integer ano, ConstraintValidatorContext context) {
        if (ano == null) {
            return true;
        }
        int anoAtual = Year.now().getValue();
        int anoMaximo = anoAtual + margemFutura;
        return ano >= anoMinimo && ano <= anoMaximo;
    }
}