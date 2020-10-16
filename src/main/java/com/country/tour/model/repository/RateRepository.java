package com.country.tour.model.repository;


import com.country.tour.model.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RateRepository extends JpaRepository<RateEntity, String> {



}
