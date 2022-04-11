package com.kdramawiki.kdramas.Service;

import java.util.List;
import java.util.Optional;

import com.kdramawiki.kdramas.Entity.User;
import com.kdramawiki.kdramas.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // - Obtener todos los usuarios
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // - Crear usuario
    public User createUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new RuntimeException("The email already exists");
        } else {
            return userRepository.save(user); 
        }   
    }

    // - Actualizar usuario
    public User updateUser(Long userId, User user) {
        User user_id = userRepository.findById(userId).get();
        user_id.setFirst_name(user.getFirst_name());
        user_id.setSurname(user.getSurname());
        user_id.setEmail(user.getEmail());
        user_id.setPassword(user.getPassword());
        return userRepository.save(user_id);
    }

    // - Eliminar usuario
    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }

    // - Obtener un usuario por su nombre
    public User getUserBySurname(String surname) {
        return userRepository.findBySurname(surname);
    }

    // - Obtener todas las listas de un usuario*/
    
}
