package com.example.Traini8.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CenterNameValidator implements ConstraintValidator<ValidCenterName, String> {

    @Override
    public void initialize(ValidCenterName constraintAnnotation){

    }

    @Override
    public boolean isValid(String centerName, ConstraintValidatorContext context) {
        return centerName != null && centerName.length() < 40;
    }
}
