package com.country.tour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RateEntity {

  @Id
  private String code;
  private Double rate;


  public RateEntity() {}

  public RateEntity(String code, Double rate) {
    super();
    this.code = code;
    this.rate = rate;
  }


}
