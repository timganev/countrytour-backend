package com.country.tour.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Integer id;

  @Column(nullable = false, unique = true)
  @Size(min = 2, max = 20, message = "Username must be between 2 and 20 symbols")
  private String username;

  @Column(nullable = false)
  @Size(min = 2, max = 120, message = "Password must be between 2 and 20 symbols")
  private String password;

  @Column(nullable = false)
  private String role;

  @Column(nullable = false)
  private Boolean active;


  public User() {
  }

  public User(String username, String password, String role, Boolean active) {
    super();
    setUsername(username);
    this.password = password;
    this.role = role;
    this.active = active;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(@Valid String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


}