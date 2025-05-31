import model.Notification;
import utils.CSVUtil;

public class TestNotifyCustomer {
    public static void main(String[] args) {
        // Create a test notification for an existing customer ID (e.g., C001)
        Notification n = new Notification("N999", "C001", "Your repair is ready for pickup.");

        try {
            CSVUtil.saveNotificationToCSV(n);
            System.out.println("✅ TestNotifyCustomer: Passed");
        } catch (Exception e) {
            System.out.println("❌ TestNotifyCustomer: Failed");
            e.printStackTrace();
        }
    }
}
