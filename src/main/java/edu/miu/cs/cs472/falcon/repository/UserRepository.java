package edu.miu.cs.cs472.falcon.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.miu.cs.cs472.falcon.model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private static List<User> dataStore = new ArrayList<>(Arrays.asList(
            new User("Tom", "Smith", "tom@gmail.com", "tom", "123456", "Male", "614-515-7175"),
            new User("Ali", "Mohamed", "mohamed@gmail.com", "ali", "123", "Male", "515-717-1313"),
            new User("Anna", "Jones", "anna@gmail.com", "anna", "568", "Female", "815-123-4568")
    ));

    public static List<User> getUsers() {
        return dataStore;
    }

    public static void registerUser(User user) {
        UserRepository.dataStore.add(user);
    }

    public static boolean isExistingUser(User user) {
        try {
            for (User current : UserRepository.getUsers()) {
                if (user.getEmail().equals(current.getEmail())
                        || user.getPhone().equals(current.getPhone())
                        || user.getUsername().equals(current.getUsername())
                ){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
