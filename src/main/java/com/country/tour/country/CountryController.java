package com.country.tour.country;


import com.country.tour.rate.RateEntity;
import com.country.tour.rate.RateRepository;
import java.util.ArrayList;
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
@RequestMapping("/countries")
public class CountryController {

  @Autowired
  private CountryRepository countryRepository;
  @Autowired
  CountryService countryService;

  @Autowired
  private RateRepository rateRepository;

  @GetMapping
  public Iterable<CountryEntity> getAll() {
    return countryRepository.findAll();
  }

//  @PostMapping
//  public ResponseEntity<Void> saveAll(@RequestBody List<CountryDTO> request) {
//    countryService.saveCountries(request);
//    return new ResponseEntity<>(HttpStatus.OK);
//    }

  @PostMapping
  public ResponseEntity<List<CountryDTO>> saveAll(@RequestBody List<CountryDTO> request) {
//    List<CountryDTO> result = new ArrayList<>();
//    List<RateEntity> fxList = rateRepository.findAll();

    countryService.saveCountries(request);

    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(request);
  }


}
