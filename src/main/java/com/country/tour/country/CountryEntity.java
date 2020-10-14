package com.country.tour.country;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
public class CountryEntity {

  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long id;
//
//  @Column(unique=true)
  private String code;

  private String country;

  private String capital;

  private String currency;

  private Double rate;

  private String neighbours;

  @CreationTimestamp
  private LocalDateTime createdOn;

  @UpdateTimestamp
  private LocalDateTime updatedOn;

  public CountryEntity() {}

//  public CountryEntity(String code) {
//    super();
//    this.code = code;
//  }


}
