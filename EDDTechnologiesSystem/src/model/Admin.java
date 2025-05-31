package model;

public class Admin extends User {

    public Admin(String userId, String name, String email, String phoneNumber) {
        super(userId, name, email, phoneNumber);
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    // Admin-specific actions can be defined here
    public void sendNotification(String message) {
        System.out.println("Notification sent to all customers: " + message);
    }

    public void flagCustomer(String customerId) {
        System.out.println("Customer with ID " + customerId + " has been flagged.");
    }

    public void addSupplier(String supplierName) {
        System.out.println("Supplier " + supplierName + " added to the system.");
    }
}
