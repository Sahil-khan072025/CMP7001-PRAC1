package model;

import java.time.LocalDateTime;

public class Notification {
    private String notificationId;
    private String recipientId;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    public Notification(String notificationId, String recipientId, String message) {
        this.notificationId = notificationId;
        this.recipientId = recipientId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    @Override
    public String toString() {
        return "Notification ID: " + notificationId + ", To: " + recipientId + ", Message: " + message +
               ", Time: " + timestamp + ", Read: " + isRead;
    }
}
