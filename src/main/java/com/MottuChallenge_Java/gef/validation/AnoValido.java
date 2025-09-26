package com.MottuChallenge_Java.gef.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AnoValidoValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnoValido {
    String message() default "Ano inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int anoMinimo() default 1000;
    int margemFutura() default 1;
}