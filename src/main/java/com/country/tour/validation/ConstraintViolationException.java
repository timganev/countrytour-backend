package com.country.tour.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstraintViolationException extends RuntimeException {

  private static final long serialVersionUID = -6144106577137904697L;

  private Map<String, String> errorMessages = new HashMap<>();

  public ConstraintViolationException(ConstraintViolation violation) {
    super(violation.getMessage());
    errorMessages.put(violation.getCode(), violation.getMessage());
  }

  public ConstraintViolationException(List<ConstraintViolation> violations) {
    violations.forEach(v -> errorMessages.put(v.getCode(), v.getMessage()));
  }

  public Map<String, String> getErrorMessages() {
    return errorMessages;
  }
}
