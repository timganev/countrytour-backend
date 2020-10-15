package com.country.tour.db.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class TourRequestDTO {

  private String code;

  private Double budget;

  private Double budgetCountry;

  private String currency;

}
