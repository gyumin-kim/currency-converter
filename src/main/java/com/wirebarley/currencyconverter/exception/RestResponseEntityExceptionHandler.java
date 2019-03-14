package com.wirebarley.currencyconverter.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Gyumin Kim
 * @since 2019-03-14
 */
@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { IllegalArgumentException.class })
  public ResponseEntity<?> clientException(RuntimeException e) {
    e.printStackTrace();
    log.info("ExceptionHandler -- clientException 발생");
    return new ResponseEntity<>("잘못된 입력입니다.", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = { InternalException.class })
  public ResponseEntity<?> serverException(RuntimeException e) {
    e.printStackTrace();
    log.info("ExceptionHandler -- serverException 발생");
    return new ResponseEntity<>("서버 에러입니다", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}