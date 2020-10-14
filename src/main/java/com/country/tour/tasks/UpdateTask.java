package com.country.tour.tasks;

import com.country.tour.fx.RatesDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class UpdateTask {

  @Autowired
  public UpdateTask() {
    super();
  }

  //  @Scheduled(cron = "0 10 3 * * *") // every day at 03:10 AM
  @Scheduled(cron = "10 * * * * *")
  private void ScheduledUpdateCoinRanks() {
    try {
      final String uri = "https://api.exchangeratesapi.io/latest";
      RestTemplate restTemplate = new RestTemplate();
      RatesDTO result = restTemplate.getForObject(uri, RatesDTO.class);
    } catch (Exception ex) {
      log.error("Failed to update due to: {}", ex);
    }
  }


}
