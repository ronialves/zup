/**
 * 
 */
package com.tlf.oss.resourceinventory.television.core.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tlf.oss.resourceinventory.television.core.validation.DetermineAvailabilityValidator;

/**
 * @author melissa.d.goncalves
 *
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { DetermineAvailabilityValidator.class})
public @interface DetermineAvailability {
	String message() default "Erro ao validar a entidade";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	String code() default "RITELEVISION-001";

}
