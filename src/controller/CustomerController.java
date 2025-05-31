package controller;

import model.Customer;
import model.Equipment;
import utils.CSVUtil;

import java.util.List;

public class CustomerController {
    private final Customer customer;

    public CustomerController(Customer customer) {
        this.customer = customer;
    }

    public void bookRepair(String equipmentId, String name, String type, String issueDescription) {
        Equipment equipment = new Equipment(equipmentId, customer.getUserId(), name, type, issueDescription);
        CSVUtil.saveEquipmentToCSV(equipment);
        System.out.println("Repair booked for equipment: " + name + " (" + type + ")");
    }

    public void upgradeToRegistered() {
        if (!customer.isRegistered()) {
            customer.upgradeToRegistered();
            CSVUtil.saveCustomerToCSV(customer);  // Add logic to overwrite or mark as registered
            System.out.println("Customer upgraded to registered status.");
        } else {
            System.out.println("Customer is already registered.");
        }
    }

    public void viewMyEquipment() {
        List<Equipment> equipmentList = CSVUtil.loadEquipmentFromCSV();
        System.out.println("Equipment for customer " + customer.getName() + ":");
        for (Equipment eq : equipmentList) {
            if (eq.getCustomerId().equals(customer.getUserId())) {
                System.out.println(eq);
            }
        }
    }

    public void receiveNotification(String message) {
        customer.receiveNotification(message);
    }
}
