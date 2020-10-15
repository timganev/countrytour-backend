package com.country.tour.service;

import com.country.tour.model.CountryDTO;
import com.country.tour.model.CountryEntity;
import com.country.tour.model.CountryRepository;
import java.util.ArrayList;
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

  public CountryDTO calculateTour(String code) {
    Optional<CountryEntity> entityOptional = countryRepository.findById(code);
    if (entityOptional.isPresent()) {
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
      CountryDTO dto = modelMapper.map(entityOptional.get(), CountryDTO.class);
      return dto;
    }
    return null;
  }








}
