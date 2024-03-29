package com.country.tour.service;

import com.country.tour.model.dto.RatesDTO;
import com.country.tour.model.entity.RateEntity;
import com.country.tour.model.repository.RateRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RateService {

  private RateRepository rateRepository;

  @Autowired
  public RateService(RateRepository rateRepository) {
    this.rateRepository = rateRepository;
  }

  public List<RateEntity> saveRates(@RequestBody RatesDTO request) {
    List<RateEntity> list = new ArrayList<>();
    request.getRates().forEach((k, v) -> {
      RateEntity entity = new RateEntity(k, v);
      list.add(entity);
    });
    rateRepository.saveAll(list);
    return list;
  }
}
