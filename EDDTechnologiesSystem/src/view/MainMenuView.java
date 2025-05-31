package view;

import controller.LoginController;
import controller.NavigationController;
import model.Admin;
import model.Customer;
import model.Technician;
import model.User;
import utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenuView {
    private final NavigationController navigationController;
    private final Scanner scanner;

    public MainMenuView(List<User> initialUsers) {
        this.navigationController = new NavigationController();
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        System.out.println("=== EDD Technologies System ===");

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Register as New User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleLogin();
                    break;
                case "2":
                    RegistrationView registrationView = new RegistrationView();
                    registrationView.display();
                    break;
                case "3":
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void handleLogin() {
        // Always reload the latest users from CSV
        List<User> users = new ArrayList<>();
        List<Admin> admins = CSVUtil.loadAdminsFromCSV();
        List<Technician> technicians = CSVUtil.loadTechniciansFromCSV();
        List<Customer> customers = CSVUtil.loadCustomersFromCSV();
        users.addAll(admins);
        users.addAll(technicians);
        users.addAll(customers);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Role (Admin / Technician / Customer): ");
        String role = scanner.nextLine();

        LoginController loginController = new LoginController(users);
        User user = loginController.login(userId, role);
        if (user != null) {
            navigationController.navigateToDashboard(user);
        }
    }
}
