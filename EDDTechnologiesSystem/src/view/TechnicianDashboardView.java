package view;

import controller.TechnicianController;
import model.Technician;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TechnicianDashboardView {
    private final Technician technician;
    private final TechnicianController technicianController;
    private final Scanner scanner;

    public TechnicianDashboardView(Technician technician) {
        this.technician = technician;
        this.technicianController = new TechnicianController(technician.getUserId());
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        while (true) {
            System.out.println("\n=== Technician Dashboard ===");
            System.out.println("1. View Assigned Jobs");
            System.out.println("2. Assess Job");
            System.out.println("3. Update Job Status");
            System.out.println("4. Logout");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    technicianController.viewAssignedJobs();
                    break;
                case "2":
                    assessJob();
                    break;
                case "3":
                    updateJobStatus();
                    break;
                case "4":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void assessJob() {
        System.out.print("Enter Job ID: ");
        String jobId = scanner.nextLine();

        List<String> tasks = new ArrayList<>();
        List<Double> costs = new ArrayList<>();

        while (true) {
            System.out.print("Enter Task Description (or 'done' to finish): ");
            String desc = scanner.nextLine();
            if (desc.equalsIgnoreCase("done")) break;

            System.out.print("Enter Cost: ");
            double cost = Double.parseDouble(scanner.nextLine());

            tasks.add(desc);
            costs.add(cost);
        }

        technicianController.assessJob(jobId, tasks, costs);
    }

    private void updateJobStatus() {
        System.out.print("Enter Job ID: ");
        String jobId = scanner.nextLine();
        System.out.print("Enter New Status: ");
        String status = scanner.nextLine();

        technicianController.updateJobStatus(jobId, status);
    }
}
