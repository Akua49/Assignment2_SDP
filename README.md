# Notification Factory System

Implementation of the Factory Method pattern for creating different types of notifications.

## 📊 UML Diagram

```mermaid
classDiagram
    direction TB

    class Notification {
        <<interface>>
        +send(message: String) void
    }

    class EmailNotification {
        +send(message: String) void
    }

    class SMSNotification {
        +send(message: String) void
    }

    class PushNotification {
        +send(message: String) void
    }

    class NotificationFactory {
        +createNotification(type: NotificationType) Notification
    }

    class NotificationType {
        <<enumeration>>
        EMAIL
        SMS
        PUSH
    }

    class Main {
        +main(args: String[]) void
    }

    Notification <|.. EmailNotification : implements
    Notification <|.. SMSNotification : implements
    Notification <|.. PushNotification : implements
    NotificationFactory --> NotificationType : uses
    NotificationFactory --> Notification : creates
    Main --> NotificationFactory : uses
    Main --> NotificationType : uses
