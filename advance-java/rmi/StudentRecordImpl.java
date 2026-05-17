import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentRecordImpl.java
 * 
 * This class IMPLEMENTS the StudentInterface - it contains the ACTUAL LOGIC.
 * 
 * KEY POINTS:
 * 1. Implements StudentInterface (the contract)
 * 2. Extends UnicastRemoteObject (makes it a remote object that can be called over network)
 * 3. Stores student records in a HashMap (in-memory database)
 * 4. All methods throw RemoteException (even if they don't actually use network internally)
 * 5. This object lives on the SERVER side
 */
public class StudentRecordImpl extends UnicastRemoteObject implements StudentInterface {
    private static final long serialVersionUID = 1L;
    
    // Database - HashMap stores all student records
    // Key: Student ID, Value: StudentRecord object
    private Map<Integer, StudentRecord> studentDatabase;
    
    // Constructor
    public StudentRecordImpl() throws RemoteException {
        super();
        this.studentDatabase = new HashMap<>();
    }
    
    /**
     * Add a new student
     */
    @Override
    public synchronized boolean addStudent(StudentRecord record) throws RemoteException {
        // Check if student ID already exists
        if (studentDatabase.containsKey(record.getStudentId())) {
            System.out.println("Student ID " + record.getStudentId() + " already exists!");
            return false;
        }
        
        // Add the student
        studentDatabase.put(record.getStudentId(), record);
        System.out.println("Student added: " + record.getName() + " (ID: " + record.getStudentId() + ")");
        return true;
    }
    
    /**
     * Get a student by ID
     */
    @Override
    public StudentRecord getStudent(int studentId) throws RemoteException {
        StudentRecord record = studentDatabase.get(studentId);
        if (record != null) {
            System.out.println("Retrieved student: " + record.getName());
        } else {
            System.out.println("Student ID " + studentId + " not found!");
        }
        return record;
    }
    
    /**
     * Update a student record
     */
    @Override
    public synchronized boolean updateStudent(StudentRecord record) throws RemoteException {
        // Check if student exists
        if (!studentDatabase.containsKey(record.getStudentId())) {
            System.out.println("Student ID " + record.getStudentId() + " not found!");
            return false;
        }
        
        // Update the student
        studentDatabase.put(record.getStudentId(), record);
        System.out.println("Student updated: " + record.getName());
        return true;
    }
    
    /**
     * Delete a student
     */
    @Override
    public synchronized boolean deleteStudent(int studentId) throws RemoteException {
        // Check if student exists
        if (!studentDatabase.containsKey(studentId)) {
            System.out.println("Student ID " + studentId + " not found!");
            return false;
        }
        
        // Remove the student
        studentDatabase.remove(studentId);
        System.out.println("Student ID " + studentId + " deleted!");
        return true;
    }
    
    /**
     * Get total number of students
     */
    @Override
    public int getTotalStudents() throws RemoteException {
        int count = studentDatabase.size();
        System.out.println("Total students: " + count);
        return count;
    }
}
