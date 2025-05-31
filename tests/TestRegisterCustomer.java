import model.Customer;
import utils.CSVUtil;

public class TestRegisterCustomer {
    public static void main(String[] args) {
        Customer customer = new Customer("C999", "TestUser", "testuser@example.com", "9999999999", true);
        try {
            CSVUtil.saveCustomerToCSV(customer);
            System.out.println("✅ TestRegisterCustomer: Passed");
        } catch (Exception e) {
            System.out.println("❌ TestRegisterCustomer: Failed");
        }
    }
}
