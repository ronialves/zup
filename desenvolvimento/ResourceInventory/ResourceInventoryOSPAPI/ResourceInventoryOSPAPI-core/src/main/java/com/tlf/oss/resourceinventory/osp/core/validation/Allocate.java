package com.tlf.oss.resourceinventory.osp.core.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { AllocateValidator.class})
public @interface Allocate {
	String message() default "Erro ao validar a entidade";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	String code() default "RIOSP-001";
}