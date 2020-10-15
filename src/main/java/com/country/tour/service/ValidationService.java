package com.country.tour.service;

import com.country.tour.model.CountryRepository;
import com.country.tour.model.RateRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {


  private ModelMapper modelMapper;

  private CountryRepository countryRepository;

  private RateRepository rateRepository;


  @Autowired
  public ValidationService(ModelMapper modelMapper,
      CountryRepository countryRepository, RateRepository rateRepository) {
    this.modelMapper = modelMapper;
    this.countryRepository = countryRepository;
    this.rateRepository = rateRepository;
  }


  public Boolean validateTour(String country, Double budget, Double budgetcountry, String currency) {
    if (!countryRepository.existsById(country)) {
      return false;
    }
    if (!isPositiveNumber(String.valueOf(budget))) {
      return false;
    }
    if (!isPositiveNumber(String.valueOf(budgetcountry))) {
      return false;
    }
//    if (!rateRepository.existsById(currency)) {
//      return false;
//    }

    return true;
  }

  private Boolean isPositiveNumber(String amount) {

    String regex = "^[+]?([.]\\d+|\\d+[.]?\\d*)$";
    Pattern pattern = Pattern.compile(regex);

    if (amount == null || amount.equals("") || !pattern.matcher(amount)
        .matches()) {
      return false;
    }
    return true;
  }


}
