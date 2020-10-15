package com.country.tour.db.dto;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class TourResponceDTO {


  private String code;

  private Double budget;

  private Double budgetCountry;

  private String currency;

  private Double leftover;

  private Integer numberTours;

  private Map<String, CountryResponceDTO> neighbours = new HashMap<>();

}
