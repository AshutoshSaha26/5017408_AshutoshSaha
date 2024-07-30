/*3.	Implement the Singleton Pattern:
o	Write code to ensure that the Logger class follows the Singleton design pattern./* */



public class Logger {
    // private static instance of the same class that is the only instance of the class
    private static Logger instance;

    // private constructor to restrict instantiation of the class from other classes
    private Logger() {
        // Initialization code
    }

    // public method to provide the single instance of the class
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        // logging logic, e.g., print to console
        System.out.println(message);
    }

    // Main method for testing Singleton pattern
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Logging from logger1");

        Logger logger2 = Logger.getInstance();
        logger2.log("Logging from logger2");

        if (logger1 == logger2) {
            System.out.println("Logger has a single instance.");
        } else {
            System.out.println("Logger instances are different.");
        }
    }
}
