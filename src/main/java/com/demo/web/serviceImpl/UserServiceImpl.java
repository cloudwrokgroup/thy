package com.demo.web.serviceImpl;

import com.demo.persistence.models.Users;
import com.demo.persistence.repos.UserRepo;
import com.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean anthenticate(String username, String password) {
        return Objects.equals(username, password);
    }

    @Override
    public List<Users> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Users findById(Long id) {
        return userRepo.findOne(id);
    }

    @Override
    public Users create(Users user) {
        return userRepo.save(user);
    }

    @Override
    public Users edit(Users user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.delete(id);
    }
}
