package view;

import controller.AdminController;
import model.Admin;
import model.Customer;
import model.RepairJob;
import model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDashboardView {
    private final AdminController adminController;
    private final Admin admin;
    private final Scanner scanner;

    public AdminDashboardView(Admin admin) {
        this.admin = admin;
        this.adminController = new AdminController();
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        while (true) {
            System.out.println("\n=== Admin Dashboard ===");
            System.out.println("1. Register New Customer");
            System.out.println("2. Assign Job to Technician");
            System.out.println("3. Cost Assessed Job");
            System.out.println("4. Notify Customer");
            System.out.println("5. Add Supplier");
            System.out.println("6. Flag Non-Paying Customer");
            System.out.println("7. View All Jobs");
            System.out.println("8. Logout");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerCustomer();
                    break;
                case "2":
                    assignJob();
                    break;
                case "3":
                    costJob();
                    break;
                case "4":
                    notifyCustomer();
                    break;
                case "5":
                    addSupplier();
                    break;
                case "6":
                    flagCustomer();
                    break;
                case "7":
                    viewAllJobs();
                    break;
                case "8":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void registerCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, email, phone, true);
        adminController.registerCustomer(customer);
    }

    private void assignJob() {
        System.out.print("Enter Job ID: ");
        String jobId = scanner.nextLine();
        System.out.print("Enter Equipment ID: ");
        String equipmentId = scanner.nextLine();
        System.out.print("Enter Technician ID: ");
        String techId = scanner.nextLine();

        RepairJob job = new RepairJob(jobId, equipmentId, techId);
        adminController.assignJobToTechnician(job);
    }

    private void costJob() {
        System.out.print("Enter Job ID: ");
        String jobId = scanner.nextLine();

        List<String> tasks = new ArrayList<>();
        List<Double> costs = new ArrayList<>();

        while (true) {
            System.out.print("Enter Task Description (or 'done' to finish): ");
            String desc = scanner.nextLine();
            if (desc.equalsIgnoreCase("done")) break;

            System.out.print("Enter Cost: ");
            try {
                double cost = Double.parseDouble(scanner.nextLine());
                tasks.add(desc);
                costs.add(cost);
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost input. Try again.");
            }
        }

        adminController.costJob(jobId, tasks, costs);
    }

    private void notifyCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, email, phone, true);

        System.out.print("Enter Notification Message: ");
        String message = scanner.nextLine();

        adminController.notifyCustomer(customer, message);
    }

    private void addSupplier() {
        System.out.print("Enter Supplier ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Location: ");
        String location = scanner.nextLine();
        System.out.print("Enter Contact Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Contact Phone: ");
        String phone = scanner.nextLine();

        Supplier supplier = new Supplier(id, name, location, email, phone);
        adminController.addSupplier(supplier);
    }

    private void flagCustomer() {
        System.out.print("Enter Customer ID to flag: ");
        String id = scanner.nextLine();
        adminController.flagNonPayingCustomer(id);
    }

    private void viewAllJobs() {
        List<RepairJob> jobs = adminController.getAllJobs();
        if (jobs.isEmpty()) {
            System.out.println("No jobs found.");
        } else {
            for (RepairJob job : jobs) {
                System.out.println(job);
            }
        }
    }
}
