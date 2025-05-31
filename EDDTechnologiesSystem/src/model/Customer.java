package model;

public class Customer extends User {
    private boolean isRegistered;

    public Customer(String userId, String name, String email, String phoneNumber, boolean isRegistered) {
        super(userId, name, email, phoneNumber);
        this.isRegistered = isRegistered;
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void upgradeToRegistered() {
        if (!isRegistered) {
            isRegistered = true;
            System.out.println("Customer " + name + " is now registered.");
        }
    }

    public void receiveNotification(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}
