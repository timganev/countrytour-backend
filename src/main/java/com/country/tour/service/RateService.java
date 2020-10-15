package com.country.tour.service;

import com.country.tour.model.RateEntity;
import com.country.tour.model.RateRepository;
import com.country.tour.model.RatesDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RateService {
  @Autowired
  private RateRepository rateRepository;

  public List<RateEntity> saveRates(
      @RequestBody RatesDTO request) {
    List<RateEntity> list = new ArrayList<>();
    request.getRates().forEach((k,v) ->{
      RateEntity entity = new RateEntity(k,v);
      list.add(entity);
    });
    rateRepository.saveAll(list);
    return list;
  }
}
