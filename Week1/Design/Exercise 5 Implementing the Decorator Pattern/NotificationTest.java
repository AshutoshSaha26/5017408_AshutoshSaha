public class NotificationTest {
    public static void main(String[] args) {
        // Create a base EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate with SMSNotifierDecorator
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        smsNotifier.send("Hello, this is a test message!");

        // Decorate with SlackNotifierDecorator
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);
        slackNotifier.send("Hello, this is a test message!");

        // Combine both SMS and Slack decorators
        Notifier combinedNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(emailNotifier));
        combinedNotifier.send("Hello, this is a combined notification!");
    }
}
