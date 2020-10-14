package com.country.tour.country;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CountryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String code;
  private String country;
  private String capital;
  private String currency;
  private Double rate;
  private String neighbours;

  public CountryEntity() {}

  public CountryEntity(String code) {
    super();
    this.code = code;
  }


}
