package com.country.tour.model.repository;

import com.country.tour.model.entity.UserEntity;
import com.country.tour.model.projection.UserView;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  UserEntity findFirstByUsername(String username);

  Optional<UserEntity> findByUsername(String userId);

  @Query(value = "SELECT u.id AS id, u.username AS username, u.role AS role FROM UserEntity AS u")
  List<UserView> findAllUsers();


}

