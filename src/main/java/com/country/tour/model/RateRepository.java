package com.country.tour.model;


import com.country.tour.model.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RateRepository extends JpaRepository<RateEntity, String> {

}
