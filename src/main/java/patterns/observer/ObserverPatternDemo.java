package patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern Example
 * 
 * The Observer pattern defines a one-to-many dependency between objects so that
 * when one object changes state, all its dependents are notified and updated
 * automatically.
 */

// Observer Interface
interface Observer {
    void update(String news);
}

// Subject Interface
interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();
}

// Concrete Subject
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println("New subscriber added!");
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println("Subscriber removed!");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestNews);
        }
    }

    public void publishNews(String news) {
        this.latestNews = news;
        System.out.println("\n--- Breaking News Published ---");
        notifyObservers();
    }
}

// Concrete Observer 1
class EmailSubscriber implements Observer {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("Email sent to " + email + ": " + news);
    }
}

// Concrete Observer 2
class SMSSubscriber implements Observer {
    private String phoneNumber;

    public SMSSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String news) {
        System.out.println("SMS sent to " + phoneNumber + ": " + news);
    }
}

// Concrete Observer 3
class AppNotificationSubscriber implements Observer {
    private String username;

    public AppNotificationSubscriber(String username) {
        this.username = username;
    }

    @Override
    public void update(String news) {
        System.out.println("Push notification to " + username + "'s app: " + news);
    }
}

// Demo class
public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        // Create subscribers
        Observer emailSub = new EmailSubscriber("john@email.com");
        Observer smsSub = new SMSSubscriber("+1234567890");
        Observer appSub = new AppNotificationSubscriber("john_doe");

        // Subscribe to news
        newsAgency.subscribe(emailSub);
        newsAgency.subscribe(smsSub);
        newsAgency.subscribe(appSub);

        // Publish news - all subscribers get notified
        newsAgency.publishNews("Design Patterns are awesome!");

        // Unsubscribe SMS
        newsAgency.unsubscribe(smsSub);

        // Publish another news
        newsAgency.publishNews("Observer Pattern implemented successfully!");
    }
}
