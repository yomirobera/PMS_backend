package com.example.pms.services.user;

import com.example.pms.models.User;
import com.example.pms.repositories.UserRepository;
import org.springframework.stereotype.Service;
import com.example.pms.utils.exceptions.*;
import java.util.HashMap;
import java.util.ArrayList;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void update(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);

    }



}
