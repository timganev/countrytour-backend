package com.country.tour.web;


import com.country.tour.model.dto.UserDto;
import com.country.tour.service.UserService;
import com.country.tour.model.entity.UserEntity;
import com.country.tour.model.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  UserRepository userRepository;

  public UserController() {

  }

  @RequestMapping("/")
  public String home() {
    return "Reporting for duty!";
  }

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(value = "/users")
  public ResponseEntity<List<UserEntity>> listUser() {
    if (userService.findAll().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Users not found");
    }
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  @PostMapping(value = "/signup")
  public ResponseEntity<UserEntity> saveUser(@RequestBody UserDto user) {

    Optional<UserEntity> optionalEntity = userRepository
        .findByUsername(user.getUsername());

    if (optionalEntity.isPresent()) {
      return ResponseEntity.badRequest().build();


    } else {

      return ResponseEntity.ok(userService.save(user));
    }
  }


}