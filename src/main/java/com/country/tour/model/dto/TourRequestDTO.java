package com.country.tour.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class TourRequestDTO {

  private String code;

  private Double budget;

  private Double budgetCountry;

  private String currency;

  public TourRequestDTO(String code, Double budget, Double budgetCountry, String currency) {
    this.code = code;
    this.budget = budget;
    this.budgetCountry = budgetCountry;
    this.currency = currency;
  }
}
