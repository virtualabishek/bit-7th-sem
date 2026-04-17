import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementation of Calculator Interface
 * Server-side logic
 */
public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {
    
    private static final long serialVersionUID = 1L;
    
    public CalculatorImpl() throws RemoteException {
        super();
    }
    
    /**
     * Adds two numbers
     */
    @Override
    public int add(int a, int b) throws RemoteException {
        // System.out.println("Server: Adding " + a + " + " + b);
        int result = a + b;
        // System.out.println("Server: Result = " + result);
        return result;
    }
}
