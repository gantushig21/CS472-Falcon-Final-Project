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
    private static List<User> dataStore = List.of(
            new User("Tom", "Bolt", "ubolt@email.com", "tom", "123456","no"),
            new User("Ali", "Mohamed", "amohd@email.com", "ali", "123","yes"),
            new User("Carly", "Jeffery", "carly@onemail.nike", "carly@onemail.nike", "carly","yes")
    );

    public static List<User> getUsers() {
        return dataStore;
    }

    public static void registerUser(User user){
        UserRepository.dataStore.add(user);
    }
}
