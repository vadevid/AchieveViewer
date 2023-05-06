package com.example.achiveserver.service;

import com.example.achiveserver.entity.User;
import com.example.achiveserver.model.UserModel;
import com.example.achiveserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel getPatientByLoginAndPassword(String login, String password) {
        try {
            User tmp = userRepository.getUserByLoginAndPassword(login, password);
            return new UserModel(tmp.getId(), tmp.getLogin(), tmp.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean registerUser(String login, String password) {
        try {
            User user = new User(login, password);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
