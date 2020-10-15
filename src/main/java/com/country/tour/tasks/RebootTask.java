package com.country.tour.tasks;

import com.country.tour.db.model.RateRepository;
import com.country.tour.service.RateService;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class RebootTask {

  private RateService rateService;
  private RateRepository rateRepository;
  private static Boolean update = true;

  @Value("classpath:states.json")
  Resource resourceFile;

  @Autowired
  public RebootTask(RateService rateService, RateRepository rateRepository) {
    super();
    this.rateService = rateService;
    this.rateRepository = rateRepository;
  }

  @PostConstruct
  public void onStartup() {
//    try {
//      Thread.sleep(1);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }

}
