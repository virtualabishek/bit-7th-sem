import java.io.Serializable;
public class StudentRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private int studentId;
    private String name;
    private String email;
    private double marks;
    public StudentRecord(int studentId, String name, String email, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }
        public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "StudentRecord{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", marks=" + marks +
                '}';
    }
}
