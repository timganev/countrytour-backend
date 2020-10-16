package com.country.tour.service;


import com.country.tour.model.entity.User;
import com.country.tour.model.dto.UserDto;
import java.util.List;

public interface UserService {

    User save(UserDto user);

    List<User> findAll();

    void delete(int id);

    User findOne(String username);

}
