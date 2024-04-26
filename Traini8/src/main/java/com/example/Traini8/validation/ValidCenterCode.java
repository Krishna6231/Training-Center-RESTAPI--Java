package com.example.Traini8.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = CenterCodeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCenterCode {
    String message() default "Center code must be exactly 12 characters alphanumeric";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
