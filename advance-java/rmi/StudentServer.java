import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * StudentServer.java
 * 
 * This is the SERVER code.
 * 
 * WHAT IT DOES:
 * 1. Creates an instance of StudentRecordImpl (the actual remote object)
 * 2. Creates/uses the RMI Registry (at port 1099)
 * 3. Binds the remote object to the registry with a name "StudentService"
 * 4. Keeps running so clients can access the service
 * 
 * ANALOGY: Like a restaurant putting their name in the phone directory
 *          so people can find and call them
 */
public class StudentServer {
    
    public static void main(String[] args) {
        try {
            System.out.println("=== Student Record Server Starting ===");
            
            // Step 1: Create the remote object (the actual implementation)
            StudentRecordImpl studentService = new StudentRecordImpl();
            System.out.println("✓ Remote object created");
            
            // Step 2: Get the RMI Registry
            // If registry doesn't exist, createRegistry creates one at port 1099
            // If it exists, LocateRegistry just gets reference to it
            try {
                LocateRegistry.createRegistry(1099);
                System.out.println("✓ New RMI Registry created on port 1099");
            } catch (RemoteException e) {
                // Registry already exists
                System.out.println("✓ Using existing RMI Registry on port 1099");
            }
            
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Step 3: Bind the remote object to the registry
            // Name: "StudentService"
            // Other applications can look this up by this name
            registry.rebind("StudentService", studentService);
            System.out.println("✓ Service bound to registry as 'StudentService'");
            
            System.out.println("\n=== Server is RUNNING and waiting for clients ===");
            System.out.println("Registry: localhost:1099");
            System.out.println("Service Name: StudentService");
            System.out.println("\nPress Ctrl+C to stop the server");
            
        } catch (RemoteException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
