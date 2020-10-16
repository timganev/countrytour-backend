package com.country.tour.model.dto;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class TourResponceDTO {


  private String code;

  private String currency;

  private Double budget;

  private Double budgetCountry;

  private Double budgetTour;

  private Integer numberTours;

  private Double leftover;

  private Map<String, CountryResponceDTO> neighbours = new HashMap<>();

}
