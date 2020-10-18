package com.country.tour.service;

import com.country.tour.model.dto.CountryDTO;
import com.country.tour.model.dto.CountryResponceDTO;
import com.country.tour.model.dto.TourRequestDTO;
import com.country.tour.model.dto.TourResponceDTO;
import com.country.tour.model.entity.CountryEntity;
import com.country.tour.model.repository.CountryRepository;
import com.country.tour.model.repository.RateRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {


  private ModelMapper modelMapper;

  private CountryRepository countryRepository;

  private RateRepository rateRepository;

  @Autowired
  public CountryService(ModelMapper modelMapper, CountryRepository countryRepository,
      RateRepository rateRepository) {
    this.modelMapper = modelMapper;
    this.countryRepository = countryRepository;
    this.rateRepository = rateRepository;
  }

  public void initialSaveCoutries(List<CountryDTO> request) {
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    List<CountryEntity> entities = new ArrayList<>();
    request.forEach(dto -> {
      CountryEntity entity = modelMapper.map(dto, CountryEntity.class);
      entities.add(entity);
    });

    countryRepository.saveAll(entities);
  }

  public TourResponceDTO calculateTour(TourRequestDTO request) {
    Optional<CountryEntity> entityOptional = countryRepository.findById(request.getCode());
    if (entityOptional.isPresent()) {
      CountryEntity countryEntity = entityOptional.get();
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
      CountryDTO countryDTO = modelMapper.map(countryEntity, CountryDTO.class);
      TourResponceDTO tourResponceDTO = modelMapper.map(request, TourResponceDTO.class);

      // todo

      tourResponceDTO
          .setBudgetCountryEUR(tourResponceDTO.getBudgetCountry() / countryEntity.getRate());

      List<String> neighbours = Arrays.asList(countryDTO.getNeighbours().split(","));

      Double budgetCountry = Math.round((tourResponceDTO.getBudgetCountry()) * 100.0) / 100.0;
      tourResponceDTO.setBudgetCountry(budgetCountry);

      Double budgetCountryEUR = Math.round((tourResponceDTO.getBudgetCountryEUR()) * 100.0) / 100.0;
      tourResponceDTO.setBudgetCountryEUR(budgetCountryEUR);

      Double budgetTour = Math.round((neighbours.size() * budgetCountry) * 100.0) / 100.0;
      tourResponceDTO.setBudgetTour(budgetTour);

      Double budget = Math.round((tourResponceDTO.getBudget()) * 100.0) / 100.0;

      Integer tours = (int) (budget / budgetTour);
      tourResponceDTO.setNumberTours(tours);

      tourResponceDTO.setLeftover(budget - budgetTour * tourResponceDTO.getNumberTours());

      neighbours.forEach(code -> {
        Optional<CountryEntity> optional = countryRepository.findById(code);
        optional.ifPresent(theUser -> {
          CountryEntity entity = optional.get();
          CountryResponceDTO countryResponceDTO = modelMapper.map(entity, CountryResponceDTO.class);
          countryResponceDTO
              .setBudgetCountry(
                  Math.round((budgetCountryEUR * tours * countryResponceDTO.getRate()) * 100.0)
                      / 100.0);
          tourResponceDTO.getNeighbours().put(code, countryResponceDTO);
        });
      });


      return tourResponceDTO;
    }
    return null;
  }


}
