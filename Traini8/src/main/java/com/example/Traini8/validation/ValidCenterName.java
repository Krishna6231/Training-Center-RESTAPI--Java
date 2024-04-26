package com.example.Traini8.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CenterNameValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCenterName {
    String message() default "Center name must be less than 40 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

