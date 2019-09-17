package com.tlf.oss.resourceinventory.tbs.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { GatherResourceValidator.class})
public @interface GatherResource {
    String message() default "Erro ao validar a entidade";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String code() default "RITBS-001";
}
