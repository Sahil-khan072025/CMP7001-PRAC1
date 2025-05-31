package controller;

import model.User;

import java.util.List;

public class LoginController {
    private final List<User> allUsers;

    public LoginController(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public User login(String userId, String role) {
        for (User user : allUsers) {
            if (user.getUserId().equals(userId) && user.getRole().equalsIgnoreCase(role)) {
                System.out.println("Login successful for " + user.getName() + " as " + role);
                return user;
            }
        }
        System.out.println("Invalid credentials or role mismatch.");
        return null;
    }

    public void logout(User user) {
        if (user != null) {
            System.out.println("User " + user.getName() + " logged out.");
        }
    }
}
