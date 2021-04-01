package com.country.tour.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
public class CountryEntity {

  @Id
  private String code;

  private String country;

  private String capital;

  private String currency;

  private Double rate;

  private String neighbours;


  @UpdateTimestamp
  private LocalDateTime updatedOn;

  public CountryEntity() {
  }

  public CountryEntity(String code, String country, String capital, String currency,
      Double rate, String neighbours) {
    this.code = code;
    this.country = country;
    this.capital = capital;
    this.currency = currency;
    this.rate = rate;
    this.neighbours = neighbours;
  }


}
