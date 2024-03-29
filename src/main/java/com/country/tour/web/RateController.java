package com.country.tour.web;


import com.country.tour.model.dto.RatesDTO;
import com.country.tour.model.entity.RateEntity;
import com.country.tour.model.repository.RateRepository;
import com.country.tour.service.RateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fx")
public class RateController {

  private RateRepository rateRepository;

  private RateService rateService;

  @Autowired
  public RateController(RateRepository rateRepository,
      RateService rateService) {
    this.rateRepository = rateRepository;
    this.rateService = rateService;
  }




  @GetMapping
  public Iterable<RateEntity> getAll() {
    return rateRepository.findAll();
  }


  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping
  public ResponseEntity<List<RateEntity>> saveAll(@RequestBody RatesDTO request) {

    List<RateEntity> list = rateService.saveRates(request);
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(list);
  }


}
