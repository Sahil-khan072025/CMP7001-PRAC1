package view;

import controller.LoginController;
import controller.NavigationController;
import model.User;

import java.util.List;
import java.util.Scanner;

public class LoginView {
    private LoginController loginController;
    private NavigationController navigationController;
    private Scanner scanner;

    public LoginView(List<User> users) {
        this.loginController = new LoginController(users);
        this.navigationController = new NavigationController();
        this.scanner = new Scanner(System.in);
    }

    public void displayLogin() {
        System.out.println("\n=== Login ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Role (Admin / Technician / Customer): ");
        String role = scanner.nextLine();

        User user = loginController.login(userId, role);

        if (user != null) {
            navigationController.navigateToDashboard(user);
        } else {
            System.out.println("Login failed. Try again.");
        }
    }
}
