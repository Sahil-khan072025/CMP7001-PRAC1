package factories;

import model.Admin;
import model.Customer;
import model.Technician;
import model.User;

public class UserFactory {

    public static User createUser(String role, String userId, String name, String email, String phone, String extra) {
        switch (role.toLowerCase()) {
            case "admin":
                return new Admin(userId, name, email, phone);
            case "technician":
                return new Technician(userId, name, email, phone, extra); // extra = specialization
            case "customer":
                boolean isRegistered = Boolean.parseBoolean(extra);       // extra = registration status
                return new Customer(userId, name, email, phone, isRegistered);
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}
