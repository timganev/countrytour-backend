package com.country.tour.fx;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String code;
  private Double rate;
//  private String base;
//  private Long timestamp;

  public RateEntity() {}

  public RateEntity(String code, Double rate) {
    super();
    this.code = code;
    this.rate = rate;
  }


}
