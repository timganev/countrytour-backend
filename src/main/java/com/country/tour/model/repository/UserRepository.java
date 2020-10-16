package com.country.tour.model.repository;

import com.country.tour.model.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findFirstByUsername(String username);
    Optional<UserEntity> findByUsername(String userId);
//    Page<User> findAllByUsername(String username, Pageable page);

}

