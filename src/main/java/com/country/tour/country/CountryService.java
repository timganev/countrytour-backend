package com.country.tour.country;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private CountryRepository countryRepository;



  public void initialSaveCoutries(List<CountryDTO> request) {
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    List<CountryEntity> entities = new ArrayList<>();
    request.forEach(dto -> {
      CountryEntity entity = modelMapper.map(dto, CountryEntity.class);
      entities.add(entity);
    });

    countryRepository.saveAll(entities);

  }
}
