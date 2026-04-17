import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote Interface for Calculator
 * Defines remote methods
 */
public interface CalculatorInterface extends Remote {
    
    /**
     * Adds two numbers
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     * @throws RemoteException
     */
    int add(int a, int b) throws RemoteException;
}
