package com.wirebarley.currencyconverter.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = WiringAmountsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface WiringAmountsConstraint {
  String message() default "송금액이 바르지 않습니다";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
