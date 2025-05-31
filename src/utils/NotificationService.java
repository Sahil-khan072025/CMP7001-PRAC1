package utils;

import model.Customer;
import model.Notification;

public class NotificationService {

    public static void sendNotification(Customer customer, String message) {
        if (customer == null || message == null || message.isEmpty()) {
            System.out.println("Notification could not be sent: missing data.");
            return;
        }

        Notification notification = new Notification(
                "N" + System.currentTimeMillis(),
                customer.getUserId(),
                message
        );

        customer.receiveNotification(message);
        CSVUtil.saveNotificationToCSV(notification);
    }
}
