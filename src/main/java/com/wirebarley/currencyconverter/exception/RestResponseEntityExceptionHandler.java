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

  //TODO: API상의 문제로 지연시간이 길어질 경우에 대한 예외처리가 있으면 좋을 것 같다.
  @ExceptionHandler(value = { InternalException.class })
  public ResponseEntity<?> serverException(RuntimeException e) {
    e.printStackTrace();
    log.info("ExceptionHandler -- serverException 발생");
    return new ResponseEntity<>("서버 에러입니다", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}