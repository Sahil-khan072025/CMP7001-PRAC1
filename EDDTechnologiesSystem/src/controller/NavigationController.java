package controller;

import model.*;
import view.*;

public class NavigationController {

    public void navigateToDashboard(User user) {
        System.out.println("Navigating to Admin Dashboard...");

        if (user instanceof Admin) {
            AdminDashboardView adminView = new AdminDashboardView((Admin) user);
            adminView.display();

        } else if (user instanceof Technician) {
            TechnicianDashboardView techView = new TechnicianDashboardView((Technician) user);
            techView.display();

        } else if (user instanceof Customer) {
            CustomerDashboardView customerView = new CustomerDashboardView((Customer) user);
            customerView.display();

        } else {
            System.out.println("Unknown user role. Cannot navigate.");
        }
    }
}
