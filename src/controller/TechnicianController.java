package controller;

import model.RepairJob;
import utils.CSVUtil;

import java.util.List;

public class TechnicianController {
    private final String technicianId;

    public TechnicianController(String technicianId) {
        this.technicianId = technicianId;
    }

    public void viewAssignedJobs() {
        List<RepairJob> jobs = CSVUtil.loadJobsFromCSV();
        System.out.println("Assigned Jobs for Technician ID " + technicianId + ":");
        for (RepairJob job : jobs) {
            if (job.getTechnicianId().equals(technicianId)) {
                System.out.println(job);
            }
        }
    }

    public void assessJob(String jobId, List<String> taskDescriptions, List<Double> taskCosts) {
        List<RepairJob> jobs = CSVUtil.loadJobsFromCSV();
        boolean found = false;

        for (RepairJob job : jobs) {
            if (job.getJobId().equals(jobId) && job.getTechnicianId().equals(technicianId)) {
                for (int i = 0; i < taskDescriptions.size(); i++) {
                    job.addRepairTask(taskDescriptions.get(i), taskCosts.get(i));
                }
                job.setStatus("Job Assessed");
                CSVUtil.updateJobInCSV(job);
                System.out.println("Job " + jobId + " has been assessed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No matching job found for assessment.");
        }
    }

    public void updateJobStatus(String jobId, String newStatus) {
        List<RepairJob> jobs = CSVUtil.loadJobsFromCSV();
        boolean updated = false;

        for (RepairJob job : jobs) {
            if (job.getJobId().equals(jobId) && job.getTechnicianId().equals(technicianId)) {
                job.setStatus(newStatus);
                CSVUtil.updateJobInCSV(job);
                System.out.println("Job ID " + jobId + " updated to status: " + newStatus);
                updated = true;
                break;
            }
        }

        if (!updated) {
            System.out.println("Job not found or not assigned to this technician.");
        }
    }
}
