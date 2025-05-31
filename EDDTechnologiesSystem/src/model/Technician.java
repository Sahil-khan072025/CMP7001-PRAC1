package model;

public class Technician extends User {
    private String specialization;

    public Technician(String userId, String name, String email, String phoneNumber, String specialization) {
        super(userId, name, email, phoneNumber);
        this.specialization = specialization;
    }

    @Override
    public String getRole() {
        return "Technician";
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void assessJob(String jobId) {
        System.out.println("Technician " + name + " has assessed job: " + jobId);
    }

    public void updateJobStatus(String jobId, String status) {
        System.out.println("Job ID " + jobId + " status updated to: " + status);
    }
}
