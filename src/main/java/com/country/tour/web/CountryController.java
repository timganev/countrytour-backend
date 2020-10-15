package com.country.tour.web;


import com.country.tour.model.CountryDTO;
import com.country.tour.model.CountryEntity;
import com.country.tour.model.CountryRepository;
import com.country.tour.model.RateRepository;
import com.country.tour.service.CountryService;
import com.country.tour.service.ValidationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {


  private CountryRepository countryRepository;

  private CountryService countryService;

  private ValidationService validationService;

  private RateRepository rateRepository;

  @Autowired
  public CountryController(CountryRepository countryRepository,
      CountryService countryService, ValidationService validationService,
      RateRepository rateRepository) {
    this.countryRepository = countryRepository;
    this.countryService = countryService;
    this.validationService = validationService;
    this.rateRepository = rateRepository;
  }

  @GetMapping
  public Iterable<CountryEntity> getAll() {
    return countryRepository.findAll();
  }


  @GetMapping("calculate")
  public ResponseEntity<CountryDTO> calculateTour
      (@RequestParam String country, @RequestParam Double budget,
          @RequestParam Double budgetcountry, @RequestParam String currency) {

    Boolean isValid = validationService.validateTour(country, budget, budgetcountry, currency);

    if (isValid) {
      CountryDTO result = countryService.calculateTour(country);
      return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
          .body(result);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }


  @PostMapping
  public ResponseEntity<List<CountryDTO>> initialSaveCountries(
      @RequestBody List<CountryDTO> request) {
    countryService.initialSaveCoutries(request);
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(request);
  }


}
