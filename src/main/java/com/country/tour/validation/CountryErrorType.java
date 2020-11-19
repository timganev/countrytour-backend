package com.country.tour.validation;


public enum CountryErrorType implements ErrorType {

  Country_301("Country code or currency can no be null or empty!"),
  Country_302("Invalid country code."),
  Country_303("Invalid currency code."),
  Country_304("Username already in use."),
  Country_305("Username can't be less then 2 or greater then 20 characters"),
  Country_306("Password can't be less then 2 or greater then 20 characters"),
  Country_307("Budget amount amust be a number and greater than 0."),
  Country_308("BudgetCountry amount must be a number and greater than 0."),

  GE_400("General Error"),
  GE_500("General Error");

  private final String defaultErrorMessage;

  private CountryErrorType(String defaultErrorMessage) {
    this.defaultErrorMessage = defaultErrorMessage;
  }

  public String getDefaultErrorMessage() {
    return defaultErrorMessage;
  }
}
