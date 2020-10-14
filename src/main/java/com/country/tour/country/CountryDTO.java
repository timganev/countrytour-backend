package com.country.tour.country;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class CountryDTO {

  private String code;
  private String country;
  private String capital;
  private String currency;
  private Double rate;
  private String neighbours;

}
