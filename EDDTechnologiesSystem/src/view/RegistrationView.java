package view;

import factories.UserFactory;
import model.Admin;
import model.Customer;
import model.Technician;
import model.User;
import utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationView {
    private final Scanner scanner;

    public RegistrationView() {
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        System.out.println("\n=== User Registration ===");

        System.out.print("Enter Role to Register (Admin / Technician / Customer): ");
        String role = scanner.nextLine().trim().toLowerCase();

        if (!role.equals("admin") && !role.equals("technician") && !role.equals("customer")) {
            System.out.println("Invalid role. Registration cancelled.");
            return;
        }

        System.out.print("Enter User ID: ");
        String id = scanner.nextLine();

        if (isUserIdTaken(id)) {
            System.out.println("User ID already exists. Please try a different ID.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        String extra = "";

        if (role.equals("technician")) {
            System.out.print("Enter Specialization (e.g., Hardware): ");
            extra = scanner.nextLine();
        } else if (role.equals("customer")) {
            extra = "true"; // default to registered
        }

        try {
            User user = UserFactory.createUser(role, id, name, email, phone, extra);
            switch (role) {
                case "technician":
                    CSVUtil.saveTechnicianToCSV((Technician) user);
                    break;
                case "customer":
                    CSVUtil.saveCustomerToCSV((Customer) user);
                    break;
                case "admin":
                    CSVUtil.saveAdminToCSV((Admin) user);
                    break;
            }
            System.out.println(role.substring(0, 1).toUpperCase() + role.substring(1) + " registered successfully.");
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    private boolean isUserIdTaken(String userId) {
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(CSVUtil.loadAdminsFromCSV());
        allUsers.addAll(CSVUtil.loadTechniciansFromCSV());
        allUsers.addAll(CSVUtil.loadCustomersFromCSV());

        for (User user : allUsers) {
            if (user.getUserId().equalsIgnoreCase(userId)) {
                return true;
            }
        }
        return false;
    }
}
