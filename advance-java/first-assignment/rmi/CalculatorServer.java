import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI Server
 * Gets existing registry, creates remote object, and binds it
 */
public class CalculatorServer {
    
    public static void main(String[] args) {
        try {
            // Get existing RMI Registry (not create)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            System.out.println("Server connected to port 1099");
            
            // Create Calculator instance
            CalculatorImpl calculator = new CalculatorImpl();
            
            // Bind to registry
            registry.rebind("Calculator", calculator);
            System.out.println("Calculator bound and ready");
            
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

