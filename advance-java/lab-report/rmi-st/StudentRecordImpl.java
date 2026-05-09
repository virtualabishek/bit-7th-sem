import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
public class StudentRecordImpl extends UnicastRemoteObject implements StudentInterface {
    private static final long serialVersionUID = 1L;
    private Map<Integer, StudentRecord> studentDatabase;
    
    public StudentRecordImpl() throws RemoteException {
        super();
        this.studentDatabase = new HashMap<>();
    }
    @Override
    public synchronized boolean addStudent(StudentRecord record) throws RemoteException {
        if (studentDatabase.containsKey(record.getStudentId())) {
            System.out.println("Student ID " + record.getStudentId() + " already exists!");
            return false;
        }
        
        studentDatabase.put(record.getStudentId(), record);
        System.out.println("Student added: " + record.getName() + " (ID: " + record.getStudentId() + ")");
        return true;
    }
    
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
    
    @Override
    public synchronized boolean updateStudent(StudentRecord record) throws RemoteException {
        if (!studentDatabase.containsKey(record.getStudentId())) {
            System.out.println("Student ID " + record.getStudentId() + " not found!");
            return false;
        }
        studentDatabase.put(record.getStudentId(), record);
        System.out.println("Student updated: " + record.getName());
        return true;
    }
    @Override
    public synchronized boolean deleteStudent(int studentId) throws RemoteException {
        if (!studentDatabase.containsKey(studentId)) {
            System.out.println("Student ID " + studentId + " not found!");
            return false;
        }
                studentDatabase.remove(studentId);
        System.out.println("Student ID " + studentId + " deleted!");
        return true;
    }
    @Override
    public int getTotalStudents() throws RemoteException {
        int count = studentDatabase.size();
        System.out.println("Total students: " + count);
        return count;
    }
}
