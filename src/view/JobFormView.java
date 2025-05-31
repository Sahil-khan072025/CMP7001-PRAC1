package view;

import model.RepairJob;

import java.util.List;
import java.util.Scanner;

public class JobFormView {
    private Scanner scanner;

    public JobFormView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayJobDetails(List<RepairJob> jobList) {
        System.out.println("\n=== All Repair Jobs ===");

        if (jobList.isEmpty()) {
            System.out.println("No jobs available.");
            return;
        }

        for (RepairJob job : jobList) {
            System.out.println(job);
        }
    }

    public String promptForJobId() {
        System.out.print("Enter Job ID: ");
        return scanner.nextLine();
    }

    public void displayJobNotFound() {
        System.out.println("Job not found.");
    }
}
