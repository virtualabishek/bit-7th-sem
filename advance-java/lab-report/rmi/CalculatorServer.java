import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class CalculatorServer {
    
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            System.out.println("Server connected to port 1099");
            CalculatorImpl calculator = new CalculatorImpl();
            registry.rebind("Calculator", calculator);
            System.out.println("Calculator bound and ready");
            
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
