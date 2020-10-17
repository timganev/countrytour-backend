package com.country.tour.validation;

import com.country.tour.validation.ConstraintViolationException;
import com.country.tour.validation.RestExceptionHandlerUtil;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(value = {ConstraintViolationException.class})
  public final ResponseEntity<Map<String, String>> handleConstraintViolationException(
      ConstraintViolationException ex) {
    return RestExceptionHandlerUtil.handleConstraintViolationException(ex);
  }

}
