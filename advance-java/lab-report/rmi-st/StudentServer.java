import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentServer {

    public static void main(String[] args) {
        try {
            StudentRecordImpl studentService = new StudentRecordImpl();
            System.out.println("Remote object created");

            try {
                LocateRegistry.createRegistry(1099);
                System.out.println("New RMI Registry created on port 1099");
            } catch (RemoteException e) {
                System.out.println(e.getMessage());
            }

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            registry.rebind("StudentService", studentService);
            System.out.println("Service bound to registry as 'StudentService'");
        } catch (RemoteException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
