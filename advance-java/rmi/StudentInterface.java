import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * StudentInterface.java
 * 
 * This is the REMOTE INTERFACE - it defines what methods can be called remotely.
 * 
 * KEY POINTS:
 * 1. Must extend Remote (from java.rmi package)
 * 2. All methods must throw RemoteException (network can fail anytime)
 * 3. This is like a CONTRACT - what the server promises to provide
 * 4. Client will use this interface to call remote methods
 */
public interface StudentInterface extends Remote {
    
    /**
     * Add a new student record
     * @param record The student record to add
     * @return true if added successfully, false if ID already exists
     * @throws RemoteException if network communication fails
     */
    boolean addStudent(StudentRecord record) throws RemoteException;
    
    /**
     * Get a student record by ID
     * @param studentId The ID of the student to retrieve
     * @return StudentRecord object if found, null if not found
     * @throws RemoteException if network communication fails
     */
    StudentRecord getStudent(int studentId) throws RemoteException;
    
    /**
     * Update an existing student record
     * @param record The updated student record
     * @return true if updated successfully, false if not found
     * @throws RemoteException if network communication fails
     */
    boolean updateStudent(StudentRecord record) throws RemoteException;
    
    /**
     * Delete a student record by ID
     * @param studentId The ID of the student to delete
     * @return true if deleted successfully, false if not found
     * @throws RemoteException if network communication fails
     */
    boolean deleteStudent(int studentId) throws RemoteException;
    
    /**
     * Get total number of students
     * @return Number of students in the system
     * @throws RemoteException if network communication fails
     */
    int getTotalStudents() throws RemoteException;
}
