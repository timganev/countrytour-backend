package com.country.tour.service;

import com.country.tour.model.dto.CountryDTO;
import com.country.tour.model.dto.CountryResponceDTO;
import com.country.tour.model.dto.TourRequestDTO;
import com.country.tour.model.dto.TourResponceDTO;
import com.country.tour.model.entity.CountryEntity;
import com.country.tour.model.repository.CountryRepository;
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

  @Autowired
  public CountryService(ModelMapper modelMapper,
      CountryRepository countryRepository) {
    this.modelMapper = modelMapper;
    this.countryRepository = countryRepository;
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

      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
      CountryDTO countryDTO = modelMapper.map(entityOptional.get(), CountryDTO.class);
      TourResponceDTO tourResponceDTO = modelMapper.map(request, TourResponceDTO.class);

      List<String> neighbours = Arrays.asList(countryDTO.getNeighbours().split(","));

      Double budgetCtr = Math.round((tourResponceDTO.getBudgetCountry()) * 100.0) / 100.0;
      Double budgetTour = Math.round((neighbours.size() * budgetCtr) * 100.0) / 100.0;
      Double budget = Math.round((tourResponceDTO.getBudget()) * 100.0) / 100.0;
      Integer tours = (int) (budget / budgetTour);

      neighbours.forEach(code -> {
        Optional<CountryEntity> optional = countryRepository.findById(code);
        optional.ifPresent(theUser -> {
          CountryEntity entity = optional.get();
          CountryResponceDTO countryResponceDTO = modelMapper.map(entity, CountryResponceDTO.class);
          countryResponceDTO
              .setBudgetCountry(
                  Math.round((budgetCtr * tours * countryResponceDTO.getRate()) * 100.0) / 100.0);
          tourResponceDTO.getNeighbours().put(code, countryResponceDTO);
        });
      });

      tourResponceDTO.setBudgetCountry(budgetCtr);
      tourResponceDTO.setBudgetTour(budgetTour);
      tourResponceDTO.setNumberTours(tours);
      tourResponceDTO.setLeftover(budget - budgetTour * tourResponceDTO.getNumberTours());
      return tourResponceDTO;
    }
    return null;
  }


}
