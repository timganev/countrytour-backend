package com.country.tour.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class ConstraintViolation {

  private String code;
  private String message;

}
