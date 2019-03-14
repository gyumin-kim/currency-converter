package com.wirebarley.currencyconverter.exception;

/**
 * @author Gyumin Kim
 * @since 2019-03-14
 */
public class InternalException extends RuntimeException {

  public InternalException() {
  }

  public InternalException(String exception) {
    super(exception);
  }
}
