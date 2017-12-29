package com.demo.web.service;

import com.demo.persistence.models.Users;

import java.util.List;

public interface UserService {
    boolean anthenticate(String username, String password);

    List<Users> findAll();

    Users findById(Long id);

    Users create(Users user);

    Users edit(Users user);

    void deleteById(Long id);
}
