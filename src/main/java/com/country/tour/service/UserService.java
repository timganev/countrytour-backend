package com.country.tour.service;


import com.country.tour.model.entity.UserEntity;
import com.country.tour.model.dto.UserDto;
import java.util.List;

public interface UserService {

    UserEntity save(UserDto user);

    List<UserEntity> findAll();

    void delete(int id);

    UserEntity findOne(String username);

}
