package com.country.tour.validation;

import com.country.tour.validation.ConstraintViolationException;
import com.country.tour.validation.RestExceptionHandlerUtil;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(value = {ConstraintViolationException.class})
  public final ResponseEntity<Map<String, String>> handleConstraintViolationException(
      ConstraintViolationException ex) {
    return RestExceptionHandlerUtil.handleConstraintViolationException(ex);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {

    return RestExceptionHandlerUtil.handleMethodArgumentNotValidException(ex,
        CountryErrorType.class);
  }

  @ExceptionHandler(Throwable.class)
  public final ResponseEntity<Map<String, String>> handleThrowable(Throwable ex) {
    return RestExceptionHandlerUtil.handleThrowable(ex, CountryErrorType.GE_500);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public final ResponseEntity<Map<String, String>> handleMissingServletRequestParameterException(
      MissingServletRequestParameterException ex) {
    return RestExceptionHandlerUtil
        .handleMissingServletRequestParameterException(ex, CountryErrorType.GE_400);
  }
}
