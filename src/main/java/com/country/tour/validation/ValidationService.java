package com.country.tour.validation;

import static com.country.tour.validation.CountryErrorType.Country_301;
import static com.country.tour.validation.CountryErrorType.Country_302;
import static com.country.tour.validation.CountryErrorType.Country_303;
import static com.country.tour.validation.CountryErrorType.Country_304;
import static com.country.tour.validation.CountryErrorType.Country_305;
import static com.country.tour.validation.CountryErrorType.Country_306;
import static com.country.tour.validation.CountryErrorType.Country_307;
import static com.country.tour.validation.CountryErrorType.Country_308;

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
      codeNull = Optional
          .of(new ConstraintViolation(Country_301.name(), Country_301.getDefaultErrorMessage()));
    }

    Optional<ConstraintViolation> validBuget = isAmountLessOrZero(String.valueOf(bgt), Country_307);
    Optional<ConstraintViolation> validBegetCountry = isAmountLessOrZero(String.valueOf(bgtCountry),
        Country_308);

    code = code.toUpperCase();
    currency = currency.toUpperCase();

    Optional<ConstraintViolation> validCode = Optional.empty();
    if (!countryRepository.existsById(code)) {
      validCode = Optional
          .of(new ConstraintViolation(Country_302.name(), Country_302.getDefaultErrorMessage()));
    }

    Optional<ConstraintViolation> validCurrency = Optional.empty();
    if (!rateRepository.existsById(currency)) {
      validCurrency = Optional.of(new ConstraintViolation(Country_303.name(),
          "Invalid currency code."));
    }

    createExceptionIfNeccessary(
        Arrays.asList(codeNull, validCode, validCurrency, validBuget, validBegetCountry));
  }


  private Optional<ConstraintViolation> isAmountLessOrZero(String amount, CountryErrorType code) {

    String regex = "^[+]?([.]\\d+|\\d+[.]?\\d*)$";
    Pattern pattern = Pattern.compile(regex);

    if (amount == null || amount.equals("") || !pattern.matcher(amount)
        .matches()) {
      return Optional
          .of(new ConstraintViolation(code.name(), code.getDefaultErrorMessage()));
    }
    return Optional.empty();

  }

  public void validateUser(UserDto request) {

    Optional<ConstraintViolation> usedUsername = Optional.empty();
    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
      usedUsername = Optional.of(new ConstraintViolation(Country_304.name(),
          Country_304.getDefaultErrorMessage()));
    }

    Optional<ConstraintViolation> validUsername = Optional.empty();
    if (!isLessGreater(String.valueOf(request.getUsername()))) {
      validUsername = Optional.of(new ConstraintViolation(Country_305.name(),
          Country_305.getDefaultErrorMessage()));
    }

    Optional<ConstraintViolation> validPassword = Optional.empty();
    if (!isLessGreater(String.valueOf(request.getPassword()))) {
      validPassword = Optional.of(new ConstraintViolation(Country_306.name(),
          Country_306.getDefaultErrorMessage()));
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
