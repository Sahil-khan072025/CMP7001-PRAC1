package view;

import controller.CustomerController;
import model.Customer;

import java.util.Scanner;

public class CustomerDashboardView {
    private final Customer customer;
    private final CustomerController customerController;
    private final Scanner scanner;

    public CustomerDashboardView(Customer customer) {
        this.customer = customer;
        this.customerController = new CustomerController(customer);
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        while (true) {
            System.out.println("\n=== Customer Dashboard ===");
            System.out.println("1. Book Equipment for Repair");
            System.out.println("2. Upgrade to Registered Customer");
            System.out.println("3. View My Equipment");
            System.out.println("4. Logout");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    bookRepair();
                    break;
                case "2":
                    customerController.upgradeToRegistered();
                    break;
                case "3":
                    customerController.viewMyEquipment();
                    break;
                case "4":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void bookRepair() {
        System.out.print("Enter Equipment ID: ");
        String equipmentId = scanner.nextLine();
        System.out.print("Enter Equipment Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Equipment Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Issue Description: ");
        String issue = scanner.nextLine();

        customerController.bookRepair(equipmentId, name, type, issue);
    }
}
