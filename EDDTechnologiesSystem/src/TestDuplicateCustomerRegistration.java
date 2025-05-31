import model.Customer;
import utils.CSVUtil;

import java.util.List;

public class TestDuplicateCustomerRegistration {
    public static void main(String[] args) {
        String testId = "C001"; // Assume C001 already exists
        List<Customer> customers = CSVUtil.loadCustomersFromCSV();

        boolean exists = customers.stream().anyMatch(c -> c.getUserId().equalsIgnoreCase(testId));
        if (exists) {
            System.out.println("✅ TestDuplicateCustomerRegistration: Passed");
        } else {
            System.out.println("❌ TestDuplicateCustomerRegistration: Failed (Customer not found)");
        }
    }
}
