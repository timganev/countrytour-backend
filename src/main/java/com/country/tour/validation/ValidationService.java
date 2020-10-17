package com.country.tour.validation;

import com.country.tour.model.dto.UserDto;
import com.country.tour.model.repository.CountryRepository;
import com.country.tour.model.repository.RateRepository;
import com.country.tour.model.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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


  public void validateTour(String code, Double bgt, Double bgtCountry, String currency) {

    Optional<ConstraintViolation> codeNull = Optional.empty();
    if (code == null || code.equals("") || currency == null || currency.equals("")) {
      codeNull = Optional.of(new ConstraintViolation("Country&Currency1",
          "Country code or currency can no be null or empty."));
    }

    Optional<ConstraintViolation> bugetLessOrZero = isAmountLessOrZero(String.valueOf(bgt),
        "budget");
    Optional<ConstraintViolation> bugetCoutryLessOrZero = isAmountLessOrZero(
        String.valueOf(bgtCountry),
        "budgetCountry");

    code = code.toUpperCase();
    currency = currency.toUpperCase();

    Optional<ConstraintViolation> validCode = Optional.empty();
    if (!countryRepository.existsById(code)) {
      validCode = Optional.of(new ConstraintViolation("Country&Currency2",
          "Invalid country code."));
    }

    Optional<ConstraintViolation> validCurrency = Optional.empty();
    if (!rateRepository.existsById(currency)) {
      validCurrency = Optional.of(new ConstraintViolation("Country&Currency3",
          "Invalid currency code."));
    }

    createExceptionIfNeccessary(
        Arrays.asList(codeNull, validCode, validCurrency, bugetLessOrZero, bugetCoutryLessOrZero));
  }


  private Optional<ConstraintViolation> isAmountLessOrZero(String amount, String errCode) {

    String regex = "^[+]?([.]\\d+|\\d+[.]?\\d*)$";
    Pattern pattern = Pattern.compile(regex);

    if (amount == null || amount.equals("") || !pattern.matcher(amount)
        .matches()) {
      return Optional
          .of(new ConstraintViolation(errCode, "Amount must be a number and greater than 0."));
    }
    return Optional.empty();

  }

  public void validateUser(UserDto request) {

    Optional<ConstraintViolation> usedUsername = Optional.empty();
    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
      usedUsername = Optional.of(new ConstraintViolation("username1",
          "Username already in use."));
    }

    Optional<ConstraintViolation> validUsername = Optional.empty();
    if (!isLessGreater(String.valueOf(request.getUsername()))) {
      usedUsername = Optional.of(new ConstraintViolation("username2",
          "Can't be less then 2 or greater then 20 characters"));
    }

    Optional<ConstraintViolation> validPassword = Optional.empty();
    if (!isLessGreater(String.valueOf(request.getPassword()))) {
      usedUsername = Optional.of(new ConstraintViolation("password1",
          "Can't be less then 2 or greater then 20 characters"));
    }

    createExceptionIfNeccessary(
        Arrays.asList(usedUsername, validUsername, validPassword));
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

  private void createExceptionIfNeccessary(List<Optional<ConstraintViolation>> exceptions) {
    List<ConstraintViolation> violations = exceptions.stream().filter(c -> c.isPresent())
        .map(c -> c.get()).collect(Collectors.toList());
    if (violations.size() > 0) {
      throw new ConstraintViolationException(violations);
    }
  }


}
