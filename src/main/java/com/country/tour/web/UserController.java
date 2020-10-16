package com.country.tour.web;


import com.country.tour.model.dto.UserDto;
import com.country.tour.model.entity.User;
import com.country.tour.model.repository.UserRepository;
import com.country.tour.service.UserService;
import com.country.tour.service.ValidationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {


  private UserService userService;

  private UserRepository userRepository;

  private ValidationService validationService;

  @Autowired
  public UserController(UserService userService, UserRepository userRepository,
      ValidationService validationService) {
    this.userService = userService;
    this.userRepository = userRepository;
    this.validationService = validationService;
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(value = "/users")
  public ResponseEntity<List<User>> listUser() {
    if (userService.findAll().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Users not found");
    }
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping(value = "/users/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
    try {
      userService.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception exception) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "User not found");
    }
  }

//  @PreAuthorize("hasRole('ADMIN')")
//  @PutMapping(value = "/users/{id}")
//  public ResponseEntity<Void> editUser(@PathVariable("id") int id) {
//    try {
//
//      userService.delete(id);
//      return new ResponseEntity<>(HttpStatus.OK);
//    } catch (Exception exception) {
//      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//          "User not found");
//    }
//  }


  @PostMapping(value = "/signup")
  public ResponseEntity<User> saveUser(@RequestBody UserDto request) {

    Boolean isValid = validationService.validateUser(request);

    if (isValid) {
      User result = userService.save(request);
      return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
          .body(result);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }


}