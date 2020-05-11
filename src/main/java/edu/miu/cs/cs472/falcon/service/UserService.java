package edu.miu.cs.cs472.falcon.service;

import edu.miu.cs.cs472.falcon.model.User;
import edu.miu.cs.cs472.falcon.repository.UserRepository;

import java.util.List;

public class UserService {

    public void registerUser(User user) {
        UserRepository.registerUser(user);
    }

    public List<User> getUsers() {
        return UserRepository.getUsers();
    }

    public User getUserById(int userId) {
        User searchUser = null;
        try {
            for (User user : UserRepository.getUsers()) {
                if (user.getUserId() == userId) {
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchUser;
    }

}
