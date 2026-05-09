import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            CalculatorInterface calculator = 
                (CalculatorInterface) registry.lookup("Calculator");
            int result = calculator.add(10, 20);
            System.out.println("Result: 10 + 20 = " + result);
        } catch (NotBoundException e) {
            System.err.println("Error: Calculator not found in registry");
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}