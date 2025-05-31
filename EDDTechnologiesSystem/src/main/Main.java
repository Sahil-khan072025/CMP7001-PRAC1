package main;

import model.*;
import utils.CSVUtil;
import view.MainMenuView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Ensure all necessary CSV files are created
        CSVUtil.initializeCSVFiles();

        // Step 2: Load data from CSV
        List<Admin> admins = CSVUtil.loadAdminsFromCSV();
        List<Technician> technicians = CSVUtil.loadTechniciansFromCSV();
        List<Customer> customers = CSVUtil.loadCustomersFromCSV();

        // Step 3: Combine all into a single User list for login
        List<User> users = new ArrayList<>();
        users.addAll(admins);
        users.addAll(technicians);
        users.addAll(customers);

        // Step 4: Launch Main Menu
        MainMenuView menu = new MainMenuView(users);
        menu.display();
    }
}
