import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class StudentClient {
    
    public static void main(String[] args) {
        try {
            System.out.println("Connecting to RMI Registry at localhost:1099...");
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            StudentInterface studentService = 
                (StudentInterface) registry.lookup("StudentService");
            System.out.println("Connected to StudentService!\n");
    
            System.out.println("--- Adding Students ---");
            studentService.addStudent(new StudentRecord(1, "Abishek", "abi@abishekn.com.np", 85.5));
            studentService.addStudent(new StudentRecord(2, "Priya Thapa", "priya@mail.com", 92.0));
            studentService.addStudent(new StudentRecord(3, "Amit Magar", "amit@gmail.com", 78.0));

            int total = studentService.getTotalStudents();
            System.out.println("Total students in system: " + total);
            StudentRecord student = studentService.getStudent(1);
            System.out.println("Retrieved: " + student);
            StudentRecord updatedRecord = new StudentRecord(2, "Priya Thapa Gurung", "priya.new@maile.com", 95.0);
            studentService.updateStudent(updatedRecord);
            System.out.println("Updated student 2");
            StudentRecord updated = studentService.getStudent(2);
            System.out.println("Updated record: " + updated);
            studentService.deleteStudent(3);
            System.out.println("Deleted student 3");
            int finalCount = studentService.getTotalStudents();
            System.out.println("Students remaining: " + finalCount);
            
        } catch (NotBoundException e) {
            System.err.println("ERROR: StudentService not found in registry");
            System.err.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
