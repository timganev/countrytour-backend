package com.country.tour.service;

import com.country.tour.db.dto.CountryDTO;
import com.country.tour.db.dto.TourRequestDTO;
import com.country.tour.db.dto.TourResponceDTO;
import com.country.tour.db.model.CountryEntity;
import com.country.tour.db.model.CountryRepository;
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

      List<String> items = Arrays.asList(countryDTO.getNeighbours().split(","));

      return tourResponceDTO;
    }
    return null;
  }


}
