package com.country.tour.model.repository;

import com.country.tour.model.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByUsername(String username);
    Optional<User> findByUsername(String userId);
//    Page<User> findAllByUsername(String username, Pageable page);

}

