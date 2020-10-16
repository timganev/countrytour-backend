package com.country.tour.service;

import com.country.tour.model.dto.TourRequestDTO;
import com.country.tour.model.dto.UserDto;
import com.country.tour.model.entity.User;
import com.country.tour.model.repository.CountryRepository;
import com.country.tour.model.repository.RateRepository;
import com.country.tour.model.repository.UserRepository;
import java.util.Optional;
import java.util.regex.Pattern;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {


  private ModelMapper modelMapper;

  private CountryRepository countryRepository;

  private RateRepository rateRepository;

  private UserRepository userRepository;


  @Autowired
  public ValidationService(ModelMapper modelMapper,
      CountryRepository countryRepository, RateRepository rateRepository,
      UserRepository userRepository) {
    this.modelMapper = modelMapper;
    this.countryRepository = countryRepository;
    this.rateRepository = rateRepository;
    this.userRepository = userRepository;
  }


  public Boolean validateTour(TourRequestDTO request) {
    if (!countryRepository.existsById(request.getCode())) {
      return false;
    }
    if (!isPositiveNumber(String.valueOf(request.getBudget()))) {
      return false;
    }
    if (!isPositiveNumber(String.valueOf(request.getBudgetCountry()))) {
      return false;
    }

//    if (!rateRepository.existsById(request.getCurrency())) {
//      return false;
//    }

    return true;
  }

  public Boolean validateUser(UserDto request) {

    Optional<User> optionalEntity = userRepository.findByUsername(request.getUsername());

    if (optionalEntity.isPresent()) {
      return false;
    }

    if (!isLessGreater(String.valueOf(request.getUsername()))) {
      return false;
    }

    if (!isLessGreater(String.valueOf(request.getPassword()))) {
      return false;
    }

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

  private Boolean isLessGreater(String str) {
    String regex = "^.{2,20}$";
    Pattern pattern = Pattern.compile(regex);

    if (str == null || str.equals("") || !pattern.matcher(str)
        .matches()) {
      return false;
    }
    return true;
  }

}
