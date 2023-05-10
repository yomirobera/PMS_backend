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
    public static int convert(String s){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //Process char
            numbers.add(map.get(String.format("%s",c)));
        }

        int total = 0;
        for (int i = 0; i < numbers.size()-1 ; i++) {
            if(numbers.get(i) >= numbers.get(i+1)){
                total += numbers.get(i);
                System.out.printf("%d + ",numbers.get(i));
            }else{
                total += numbers.get(i+1) - numbers.get(i);
                System.out.printf("(%d-%d) +",numbers.get(i+1),numbers.get(i));
                i++;
            }
            if(i == numbers.size()-2){
                total += numbers.get(i+1);
                System.out.printf("%d ",numbers.get(i+1));
            }

        }
        System.out.print("= ");
        return total;

    }

    @Override
    public User findById(String id) {
        System.out.println(convert(id));
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
