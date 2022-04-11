package com.kdramawiki.kdramas.Controller;

import java.util.List;

import com.kdramawiki.kdramas.Entity.User;
import com.kdramawiki.kdramas.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    //Crear nuevo usuario
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    //Actualizar usuario por ID
    @PutMapping(path = "/{user_id}")
    public User modifyUser(@PathVariable("user_id") Long user_id, @RequestBody User user) {
        return userService.updateUser(user_id, user);
    }

    // Eliminar usuarios
    @DeleteMapping(path = "/{user_id}")
    public void deleteUser(@PathVariable("user_id") Long user_id) {
        userService.deleteUser(user_id);
    }

    // - Obtener un usuario por su nombre
    @GetMapping("/surname")
    public User getUserBySurname(@RequestParam("surname") String surname) {
        return userService.getUserBySurname(surname);
    }
}
