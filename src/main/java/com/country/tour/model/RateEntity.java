package com.country.tour.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
public class RateEntity {

  @Id
  private String code;

  private Double rate;

  @UpdateTimestamp
  private LocalDateTime updatedOn;

  public RateEntity() {
  }

  public RateEntity(String code, Double rate) {
    super();
    this.code = code;
    this.rate = rate;
  }


}
