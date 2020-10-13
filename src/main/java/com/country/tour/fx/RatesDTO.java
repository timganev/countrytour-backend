package com.country.tour.fx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class RatesDTO {

  private String base;
  private String date;
  private Map<String, Double> rates = new HashMap<>();


}
