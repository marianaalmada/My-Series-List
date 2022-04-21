package com.myserieslist.serieslist.Service;

import java.util.List;
import java.util.Optional;

import com.myserieslist.serieslist.Entity.User;
import com.myserieslist.serieslist.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new RuntimeException("The email already exists");
        } else {
            return userRepository.save(user); 
        }   
    }

    public User updateUser(Long userId, User user) {
        User user_id = userRepository.findById(userId).get();
        user_id.setName(user.getName());
        user_id.setSurname(user.getSurname());
        user_id.setEmail(user.getEmail());
        user_id.setPassword(user.getPassword());
        return userRepository.save(user_id);
    }

    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }

    public User getUserBySurname(String surname) {
        return userRepository.findBySurname(surname);
    }
    
}
