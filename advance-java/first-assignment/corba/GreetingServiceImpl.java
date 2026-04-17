import GreetingModule.GreetingServicePOA;

/**
 * Implementation of Greeting Service
 * Extends POA skeleton class generated from IDL
 */
public class GreetingServiceImpl extends GreetingServicePOA {
    
    /**
     * Greet method
     * @param name Name to greet
     * @return Welcome message
     */
    @Override
    public String greet(String name) {
        // System.out.println("Server received request for: " + name);
        String message = "Welcome, " + name + "! Have a great day.";
        // System.out.println("Server returning: " + message);
        return message;
    }
}
