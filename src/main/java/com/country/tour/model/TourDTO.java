package com.country.tour.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class TourDTO {

  private String code;
  private String country;
  private String capital;
  private String currency;
  private Double rate;
  private String neighbours;

}
