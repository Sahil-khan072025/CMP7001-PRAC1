package view;

import model.Notification;

import java.util.List;

public class NotificationView {

    public void displayNotifications(List<Notification> notifications, String userId) {
        System.out.println("\n=== Notifications for User ID: " + userId + " ===");

        boolean hasNotification = false;
        for (Notification notification : notifications) {
            if (notification.getRecipientId().equals(userId)) {
                System.out.println(notification);
                hasNotification = true;
            }
        }

        if (!hasNotification) {
            System.out.println("No notifications found for this user.");
        }
    }

    public void displayNewNotification(Notification notification) {
        System.out.println("New Notification: " + notification.getMessage());
    }
}
