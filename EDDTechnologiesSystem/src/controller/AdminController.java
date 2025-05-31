package controller;

import model.*;
import utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

    public void registerCustomer(Customer customer) {
        List<Customer> customers = CSVUtil.loadCustomersFromCSV();
        customers.add(customer);
        CSVUtil.saveCustomerToCSV(customer);
        System.out.println("Customer registered: " + customer.getName());
    }

    public void assignJobToTechnician(RepairJob job) {
        List<RepairJob> jobs = CSVUtil.loadJobsFromCSV();
        jobs.add(job);
        CSVUtil.saveJobToCSV(job);
        System.out.println("Job assigned to technician: " + job.getTechnicianId());
    }

    public void costJob(String jobId, List<String> taskDescriptions, List<Double> taskCosts) {
        List<RepairJob> jobs = CSVUtil.loadJobsFromCSV();
        boolean updated = false;

        for (RepairJob job : jobs) {
            if (job.getJobId().equals(jobId)) {
                for (int i = 0; i < taskDescriptions.size(); i++) {
                    job.addRepairTask(taskDescriptions.get(i), taskCosts.get(i));
                }
                job.setStatus("Assessed");
                CSVUtil.updateJobInCSV(job);
                System.out.println("Job " + jobId + " costed and updated.");
                updated = true;
                break;
            }
        }

        if (!updated) {
            System.out.println("Job ID not found.");
        }
    }

    public void notifyCustomer(Customer customer, String message) {
        customer.receiveNotification(message);
        CSVUtil.saveNotificationToCSV(new Notification("N" + System.currentTimeMillis(), customer.getUserId(), message));
    }

    public void addSupplier(Supplier supplier) {
        List<Supplier> suppliers = CSVUtil.loadSuppliersFromCSV();
        suppliers.add(supplier);
        CSVUtil.saveSupplierToCSV(supplier);
        System.out.println("Supplier added: " + supplier.getName());
    }

    public void flagNonPayingCustomer(String customerId) {
        System.out.println("Customer " + customerId + " flagged for non-payment.");
        // Optional: add status in customers.csv if extended
    }

    public List<RepairJob> getAllJobs() {
        return CSVUtil.loadJobsFromCSV();
    }

    public List<Customer> getAllCustomers() {
        return CSVUtil.loadCustomersFromCSV();
    }

    public List<Supplier> getAllSuppliers() {
        return CSVUtil.loadSuppliersFromCSV();
    }
}
