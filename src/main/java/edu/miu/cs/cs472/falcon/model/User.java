package edu.miu.cs472.falcon.model;

import java.util.Objects;

public class User {
    private static int userId=0;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String gender;
    private String role;

    public User(){}

    public User(String firstName, String lastName, String email, String username, String password, String gender) {
        this.userId = this.getUserId()+1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object object){
        boolean same = false;
        if (object != null && object instanceof User) {
            same = this.userId == ((User) object).userId;
        }
        return same;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, username, password);
    }

}
