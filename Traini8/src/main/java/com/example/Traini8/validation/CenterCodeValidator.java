package com.example.Traini8.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CenterCodeValidator implements ConstraintValidator<ValidCenterCode, String> {

    @Override
    public void initialize(ValidCenterCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String centerCode, ConstraintValidatorContext context) {
        return centerCode != null && centerCode.matches("[a-zA-Z0-9]{12}");
    }
}

