import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {
    private static final long serialVersionUID = 1L;

    public CalculatorImpl() throws RemoteException {
        super();
    }
    @Override
    public int add(int a, int b) throws RemoteException {
        int result = a + b;
        return result;
    }
}