package com.country.tour.web;


import com.country.tour.model.dto.CountryDTO;
import com.country.tour.model.dto.TourRequestDTO;
import com.country.tour.model.dto.TourResponceDTO;
import com.country.tour.model.entity.CountryEntity;
import com.country.tour.model.repository.CountryRepository;
import com.country.tour.model.repository.RateRepository;
import com.country.tour.service.CountryService;
import com.country.tour.validation.ValidationService;
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
  public ResponseEntity<TourResponceDTO> calculateTour(
      @RequestParam String code,
      @RequestParam Double budget,
      @RequestParam Double budgetCountry,
      @RequestParam String currency) {

    validationService.validateTour(code, budget, budgetCountry, currency);

      code = code.toUpperCase();
      currency = currency.toUpperCase();
      TourRequestDTO request = new TourRequestDTO(code, budget, budgetCountry, currency);

      TourResponceDTO result = countryService.calculateTour(request);

      return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
          .body(result);

  }


  @PostMapping
  public ResponseEntity<List<CountryDTO>> initialSaveCountries(
      @RequestBody List<CountryDTO> request) {
    countryService.initialSaveCoutries(request);
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(request);
  }


}
