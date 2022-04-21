package com.myserieslist.serieslist.Controller;

import java.util.List;

import com.myserieslist.serieslist.Entity.User;
import com.myserieslist.serieslist.Service.UserService;

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

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{user_id}")
    public User modifyUser(@PathVariable("user_id") Long user_id, @RequestBody User user) {
        return userService.updateUser(user_id, user);
    }

    @DeleteMapping(path = "/{user_id}")
    public void deleteUser(@PathVariable("user_id") Long user_id) {
        userService.deleteUser(user_id);
    }

    @GetMapping("/surname")
    public User getUserBySurname(@RequestParam("surname") String surname) {
        return userService.getUserBySurname(surname);
    }
}
