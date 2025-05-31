package model;

import java.util.ArrayList;
import java.util.List;

public class RepairJob {
    private String jobId;
    private String equipmentId;
    private String technicianId;
    private String status;
    private double totalCost;
    private final List<String> taskDescriptions;
    private final List<Double> taskCosts;

    public RepairJob(String jobId, String equipmentId, String technicianId) {
        this.jobId = jobId;
        this.equipmentId = equipmentId;
        this.technicianId = technicianId;
        this.status = "Job Created";
        this.totalCost = 0.0;
        this.taskDescriptions = new ArrayList<>();
        this.taskCosts = new ArrayList<>();
    }

    public void addRepairTask(String description, double cost) {
        taskDescriptions.add(description);
        taskCosts.add(cost);
        totalCost += cost;
    }

    // ==== Getters and Setters ====

    public String getJobId() {
        return jobId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<String> getTaskDescriptions() {
        return taskDescriptions;
    }

    public List<Double> getTaskCosts() {
        return taskCosts;
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId +
               ", Equipment ID: " + equipmentId +
               ", Technician ID: " + technicianId +
               ", Status: " + status +
               ", Total Cost: " + totalCost;
    }
}
