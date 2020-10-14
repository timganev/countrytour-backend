package com.country.tour.country;


import com.country.tour.fx.RateRepository;
import com.country.tour.fx.RateEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    List<CountryDTO> result = new ArrayList<>();
    List<RateEntity> fxList = rateRepository.findAll();

    Map<String, Double> fxmap = new HashMap<>();
    fxList.forEach(fx -> {
      fxmap.put(fx.getCode(), fx.getRate());
    });

    request.forEach(v -> {

          if (!fxmap.containsKey(v.getCurrency())) {
            v.setCurrency("EUR");
            result.add(v);
          }
        }

    );

    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(request);
  }


}
