package com.deyvidsalvatore.shopinventory_api.domain.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordsMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsMatch {
	String message() default "The new and confirmation password must be equal";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}