package com.country.tour.service;

import com.country.tour.model.entity.UserEntity;
import com.country.tour.model.dto.UserDto;
import com.country.tour.model.projection.UserView;
import com.country.tour.model.repository.UserRepository;
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
    UserEntity userEntity = userRepository.findFirstByUsername(username);
    if (userEntity == null) {
      throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity
        .getPassword(), getAuthority(userEntity));
  }

  private Set<SimpleGrantedAuthority> getAuthority(UserEntity userEntity) {
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole()));
    return authorities;
  }

  public List<UserView> findAll() {
    List<UserView> list = userRepository.findAllUsers();
    return list;
  }

  @Override
  public void delete(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public UserEntity findOne(String username) {
    return userRepository.findFirstByUsername(username);
  }

  @Override
  public void update(int id, String role) {

    Optional<UserEntity> optional = userRepository.findById(id);
    if(optional.isPresent()) {
      UserEntity entity = optional.get();
      entity.setRole(role);
    }

  }


  @Override
  public UserEntity save(UserDto user) {

    UserEntity newUserEntity = new UserEntity();
    newUserEntity.setUsername(user.getUsername());
    newUserEntity.setPassword(bcryptEncoder.encode(user.getPassword()));
    newUserEntity.setActive(true);
    newUserEntity.setRole("USER");
    return userRepository.save(newUserEntity);
  }


}
