package com.country.tour.service;

import com.country.tour.model.entity.User;
import com.country.tour.model.dto.UserDto;
import com.country.tour.model.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bcryptEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findFirstByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user
        .getPassword(), getAuthority(user));
  }

  private Set<SimpleGrantedAuthority> getAuthority(User user) {
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    return authorities;
  }

  public List<User> findAll() {
    List<User> list = new ArrayList<>();
    userRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Override
  public void delete(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public User findOne(String username) {
    return userRepository.findFirstByUsername(username);
  }

  @Override
  public void update(int id, String role) {

    Optional<User> optional = userRepository.findById(id);
    if(optional.isPresent()) {
      User entity = optional.get();
      entity.setRole(role);
    }

  }


  @Override
  public User save(UserDto user) {

    User newUser = new User();
    newUser.setUsername(user.getUsername());
    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
    newUser.setActive(true);
    newUser.setRole("USER");
    return userRepository.save(newUser);
  }


}
