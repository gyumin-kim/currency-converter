package com.wirebarley.currencyconverter.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Gyumin Kim
 * @since 2019-03-13
 */
public class WiringAmountsValidator implements
    ConstraintValidator<WiringAmountsConstraint, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && isNumeric(value)
        && Double.parseDouble(value) >= 0.0
        && Double.parseDouble(value) <= 10000.0;
  }

  @Override
  public void initialize(WiringAmountsConstraint constraintAnnotation) {
  }

  private boolean isNumeric(String value) {
    try {
      Double.parseDouble(value);
      return true;
    } catch (NumberFormatException e){
      return false;
    }
  }
}
