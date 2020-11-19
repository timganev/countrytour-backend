package com.country.tour.validation;

import com.google.common.base.Enums;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;

@Slf4j
public class RestExceptionHandlerUtil {

  public static ResponseEntity<Map<String, String>> handleConstraintViolationException(
      ConstraintViolationException ex) {
    log.warn("ConstraintViolationException was thrown.", ex);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
        .body(ex.getErrorMessages());
  }

  public static <T extends Enum & ErrorType> ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex, Class<T> errorType) {

    Map<String, String> errorMap = new HashMap<String, String>();

    for (ObjectError oe : ex.getBindingResult().getAllErrors()) {
      if (Enums.getIfPresent(errorType, oe.getDefaultMessage()).isPresent()) {
        String defaultErrorMsg =
            ((ErrorType) Enum.valueOf(errorType, oe.getDefaultMessage())).getDefaultErrorMessage();
        log.warn("An error for NotValid Argument is thrown. Error code is: {} Error message is: {}",
            oe.getDefaultMessage(), defaultErrorMsg);
        errorMap.put(oe.getDefaultMessage(), defaultErrorMsg);
      } else {
        log.warn("An unexpected error for NotValid Argument is thrown. Error code is: {}",
            oe.getDefaultMessage());
        errorMap.put(oe.getDefaultMessage(), "Error msg could not be found.");
      }
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
        .body(errorMap);
  }

  public static <T extends Enum & ErrorType> ResponseEntity<Map<String, String>> handleThrowable(
      Throwable ex, T errorType) {
    Map<String, String> errorMap = new HashMap<String, String>();
    errorMap.put(errorType.name(), errorType.getDefaultErrorMessage());
    log.error("An unexpected error is thrown.", ex);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
        .body(errorMap);
  }

  public static <T extends Enum & ErrorType> ResponseEntity<Map<String, String>> handleMissingServletRequestParameterException(
      MissingServletRequestParameterException ex, T errorType) {
    Map<String, String> errorMap = new HashMap<String, String>();
    errorMap.put(errorType.name(), ex.getMessage());
    log.error("Missing Servlet Request Parameter Exception.", ex);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
        .body(errorMap);
  }
}
