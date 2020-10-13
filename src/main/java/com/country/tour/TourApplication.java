package com.country.tour;

import com.country.tour.country.CountryEntity;
import com.country.tour.country.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TourApplication {


  public static void main(String[] args) {
    SpringApplication.run(TourApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(CountryRepository userRepository) {
    return args -> {
      userRepository.save(new CountryEntity("BG"));
      userRepository.save(new CountryEntity("UK"));

    };
  }


}
