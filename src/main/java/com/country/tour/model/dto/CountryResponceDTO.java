package com.country.tour.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class CountryResponceDTO {

  private String country;

  private String currency;

  private Double rate;

  private Double budgetCountry;

}
