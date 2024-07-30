public class SingletonTest {
    public static void main(String[] args) {
        // Create the first instance
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message from SingletonTest");

        // Create the second instance
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message from SingletonTest");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Logger has a single instance.");
        } else {
            System.out.println("Logger instances are different.");
        }
    }
}
