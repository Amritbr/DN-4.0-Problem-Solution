// Design Patterns and Principles
// Exercise 1: Implementing the Singleton Pattern


public class SingletonPatternExample 
{
    // Singleton Class named Logger
    static class Logger {
        // Private static instance of Logger
        private static Logger Singleinstance;

        // Private constructor to prevent instantiation
        private Logger() {
            System.out.println("Logger Initailized ");  
        }

        // Public static method to return the single instance
        public static synchronized Logger getInstance() {
            if (Singleinstance == null) {
                Singleinstance = new Logger();
            }
            return Singleinstance;
        }

        // A method to simulate logging
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Test Singleton Implementation
    public static void main(String[] args) {
        Logger lg1 = Logger.getInstance();
        Logger lg2 = Logger.getInstance();

        // Logging some messages
        lg1.log("This is the 1st log message.");
        lg2.log("This is the 2nd log message.");
    }
}

