package com.country.tour.country;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  @Autowired
  private ModelMapper modelMapper;

  public void saveCountries(List<CountryDTO> request) {
//    modelMapper.typeMap(CountryDTO.class, CountryEntity.class)
//        .addMappings(mapper -> mapper.skip(CountryEntity::setNeighbours));

    List<CountryEntity> entities = new ArrayList<>();
    request.forEach(v -> {
      CountryEntity entity = modelMapper.map(request, CountryEntity.class);
      v.getNeighbours();
    });

  }
}
