package com.example.achiveserver.controller;

import com.example.achiveserver.model.UserLoginModel;
import com.example.achiveserver.model.UserModel;
import com.example.achiveserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "vadevid.danperad.ru")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserModel LoginUser(@RequestBody @Validated UserLoginModel user) {
        return userService.getPatientByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean RegisterUser(@RequestBody @Validated UserModel user) {
        return userService.registerUser(user.getLogin(), user.getPassword());
    }
}
