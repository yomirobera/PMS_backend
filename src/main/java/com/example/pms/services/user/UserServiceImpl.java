package com.example.pms.services.user;

import com.example.pms.models.User;
import com.example.pms.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String s) {
        return null;
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User entity) {
        return null;
    }

    @Override
    public void update(User entity) {
    }

    @Override
    public void deleteById(String s) {

    }



}
