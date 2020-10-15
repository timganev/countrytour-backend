package com.country.tour.tasks;

import com.country.tour.model.RateRepository;
import com.country.tour.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class UpdateTask {

  private RateService rateService;
  private RateRepository rateRepository;
  private static Boolean update = true;

  @Autowired
  public UpdateTask(RateService rateService, RateRepository rateRepository) {
    super();
    this.rateService = rateService;
    this.rateRepository = rateRepository;
  }

  //  @Scheduled(cron = "0 10 3 * * *") // every day at 03:10 AM
//  @Scheduled(cron = "* * * * * *") // update at start
//  private void ScheduledUpdateRates() {
//    if (update) {
//      update = false;
//      try {
//        final String uri = "https://api.exchangeratesapi.io/latest";
//        RestTemplate restTemplate = new RestTemplate();
//        RatesDTO result = restTemplate.getForObject(uri, RatesDTO.class);
//        rateService.saveRates(result);
//      } catch (Exception ex) {
//        log.error("Failed to update due to: {}", ex);
//      }
//    }
//
//  }


}
