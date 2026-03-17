package com.seuprojeto.contacts_api.entities.validation;

import com.seuprojeto.contacts_api.entities.validation.constraints.PhoneBr;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PhoneBrValidation implements ConstraintValidator<PhoneBr,String> {
    @Override
    public void initialize(PhoneBr constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isBlank()){
            return false;
        }   // remove tudo que não é número
        String digits = s.replaceAll("\\D", "");

        // tamanho inválido
        if (digits.length() != 10 && digits.length() != 11) {
            return false;
        }

        // DDD não pode começar com 0
        if (digits.startsWith("0")) {
            return false;
        }

        // celular (11 dígitos) precisa começar com 9
        if (digits.length() == 11 && digits.charAt(2) != '9') {
            return false;
        }
        return true;
    }
}
