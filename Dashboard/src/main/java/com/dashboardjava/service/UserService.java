package com.dashboardjava.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dashboardjava.model.User;
import com.dashboardjava.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
   ResponseEntity<Object> deleteuser(int id);
}
