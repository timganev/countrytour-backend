package com.country.tour.fx;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fx")
public class RateController {

  @Autowired
  private RateRepository rateRepository;

  @Autowired
  private RateService rateService;

//TODO get rates  http://data.fixer.io/api/latest?access_key=62a07267d78d80b5c5cc109268183aef


  @GetMapping
  public Iterable<RateEntity> getAll() {
    return rateRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<List<RateEntity>> saveAll(@RequestBody RatesDTO request) {

    List<RateEntity> list = rateService.saveRates(request);

    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(list);
  }



}
