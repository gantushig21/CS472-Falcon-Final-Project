package edu.miu.cs.cs472.falcon.service;

import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.repository.UserRepository;

import java.util.List;

public class LoginService {

    public boolean authenticateUser(String username, String password) {
        User user = getUserByUserName(username);
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public User getUserByUserName(String username) {
        User searchUser = null;
        try {
            for (User user : UserRepository.getUsers()) {
                if (username.equals(user.getUsername())) {
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchUser;
    }
}
