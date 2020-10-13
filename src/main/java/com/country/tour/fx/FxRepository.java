package com.country.tour.fx;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FxRepository extends JpaRepository<FxEntity, Long> {

}
