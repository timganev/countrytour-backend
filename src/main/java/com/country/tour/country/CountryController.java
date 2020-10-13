package com.country.tour.country;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {
  @Autowired
  private CountryRepository repository;

  @GetMapping
  public Iterable<CountryEntity> getAll() {
    return repository.findAll();
  }

}
