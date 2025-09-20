enum NotificationType {
    EMAIL, SMS, PUSH
}

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email notification: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS notification: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Push notification: " + message);
    }
}

class NotificationFactory {
    public Notification createNotification(NotificationType type) {
        switch (type) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification email = factory.createNotification(NotificationType.EMAIL);
        email.send("Your order has been confirmed!");

        Notification sms = factory.createNotification(NotificationType.SMS);
        sms.send("Your package has been shipped.");

        Notification push = factory.createNotification(NotificationType.PUSH);
        push.send("You have a new friend request.");
    }
}
