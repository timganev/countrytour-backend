package com.country.tour.service;


import com.country.tour.model.entity.UserEntity;
import com.country.tour.model.dto.UserDto;
import com.country.tour.model.projection.UserView;
import java.util.List;

public interface UserService {

    UserEntity save(UserDto user);

    List<UserView> findAll();

    void delete(int id);

    UserEntity findOne(String username);

  void update(int id, String role);
}
