package com.country.tour.tasks;

import com.country.tour.db.model.RateRepository;
import com.country.tour.db.dto.RatesDTO;
import com.country.tour.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class UpdateTask {

  private RateService rateService;
  private RateRepository rateRepository;
  private static Boolean update = true;

  @Value("classpath:states.json")
  Resource resourceFile;

  @Autowired
  public UpdateTask(RateService rateService, RateRepository rateRepository) {
    super();
    this.rateService = rateService;
    this.rateRepository = rateRepository;
  }


  //  @Scheduled(cron = "0 10 3 * * *") // every day at 03:10 AM
  @Scheduled(cron = "1 * * * * *") // update at start
  private void StartUpdateRates() {
    if (update) {
      update = false;
      try {
        final String uri = "https://api.exchangeratesapi.io/latest";
        RestTemplate restTemplate = new RestTemplate();
        RatesDTO result = restTemplate.getForObject(uri, RatesDTO.class);
        rateService.saveRates(result);
      } catch (Exception ex) {
        log.error("Failed to update due to: {}", ex);
      }
    }

  }

  // get rates  http://data.fixer.io/api/latest?access_key=62a07267d78d80b5c5cc109268183aef
    @Scheduled(cron = "0 0 3 * * *") // every day at 03:00 AM
  private void ScheduledUpdateRates() {
      try {
        final String uri = "http://data.fixer.io/api/latest?access_key=62a07267d78d80b5c5cc109268183aef";
        RestTemplate restTemplate = new RestTemplate();
        RatesDTO result = restTemplate.getForObject(uri, RatesDTO.class);
        rateService.saveRates(result);
      } catch (Exception ex) {
        log.error("Failed to update due to: {}", ex);
      }
  }


}
