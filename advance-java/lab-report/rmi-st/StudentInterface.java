import java.rmi.Remote;
import java.rmi.RemoteException;
public interface StudentInterface extends Remote {
    boolean addStudent(StudentRecord record) throws RemoteException;
    StudentRecord getStudent(int studentId) throws RemoteException;
    boolean updateStudent(StudentRecord record) throws RemoteException;
    boolean deleteStudent(int studentId) throws RemoteException;
    int getTotalStudents() throws RemoteException;
}
