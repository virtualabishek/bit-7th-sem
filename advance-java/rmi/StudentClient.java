import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * StudentClient.java
 * 
 * This is the CLIENT code.
 * 
 * WHAT IT DOES:
 * 1. Connects to the RMI Registry on localhost:1099
 * 2. Looks up "StudentService" from the registry
 * 3. Gets a reference to the remote StudentInterface
 * 4. Calls methods on the remote object
 * 5. Receives results from the server
 * 
 * ANALOGY: Like calling a restaurant, looking them up in the phone directory,
 *          and then placing an order
 */
public class StudentClient {
    
    public static void main(String[] args) {
        try {
            System.out.println("=== Student Record Client ===\n");
            
            // Step 1: Get reference to the RMI Registry
            System.out.println("Connecting to RMI Registry at localhost:1099...");
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Step 2: Look up the remote object by name
            System.out.println("Looking up 'StudentService'...");
            StudentInterface studentService = 
                (StudentInterface) registry.lookup("StudentService");
            System.out.println("✓ Connected to StudentService!\n");
            
            // Step 3: Call remote methods
            
            // Add some students
            System.out.println("--- Adding Students ---");
            studentService.addStudent(new StudentRecord(1, "Raj Kumar", "raj@example.com", 85.5));
            studentService.addStudent(new StudentRecord(2, "Priya Singh", "priya@example.com", 92.0));
            studentService.addStudent(new StudentRecord(3, "Amit Patel", "amit@example.com", 78.0));
            
            // Get total students
            System.out.println("\n--- Getting Total Students ---");
            int total = studentService.getTotalStudents();
            System.out.println("Total students in system: " + total);
            
            // Get a specific student
            System.out.println("\n--- Getting Specific Student ---");
            StudentRecord student = studentService.getStudent(1);
            System.out.println("Retrieved: " + student);
            
            // Update a student
            System.out.println("\n--- Updating Student ---");
            StudentRecord updatedRecord = new StudentRecord(2, "Priya Singh", "priya.new@example.com", 95.0);
            studentService.updateStudent(updatedRecord);
            System.out.println("Updated student 2");
            
            // Verify update
            System.out.println("\n--- Verifying Update ---");
            StudentRecord updated = studentService.getStudent(2);
            System.out.println("Updated record: " + updated);
            
            // Delete a student
            System.out.println("\n--- Deleting Student ---");
            studentService.deleteStudent(3);
            System.out.println("Deleted student 3");
            
            // Final count
            System.out.println("\n--- Final Count ---");
            int finalCount = studentService.getTotalStudents();
            System.out.println("Students remaining: " + finalCount);
            
            System.out.println("\n✓ All operations completed successfully!");
            
        } catch (NotBoundException e) {
            System.err.println("ERROR: StudentService not found in registry!");
            System.err.println("Make sure StudentServer is running first.");
            System.err.println(e.getMessage());
        } catch (RemoteException e) {
            System.err.println("ERROR: Network/Remote error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
