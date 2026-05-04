import java.io.*;
import java.util.*;


class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  int id;
  String name;
  double marks;
  Student(int id, String name, double marks) {
    this.id = id;
    this.name = name;
    this.marks = marks;
  }
  public String toString() {
    return "Student{id=" + id + ", name='"+ name +"', marks="+ marks + "}";
  }
}

public class SeriDeri {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String fileName = "student.dat";
    System.out.println("How many students? ");
    int n = Integer.parseInt(scanner.nextLine().trim());
    List<Student> students = new ArrayList<>();
    for (int i = 0; i<n; i++) {
      System.out.println("Enter details for student " + (i + 1));
      System.out.print("ID: ");
      int id = Integer.parseInt(scanner.nextLine().trim());
      System.out.println("Name: ");
      String name = scanner.nextLine().trim();
      System.out.println("Marks: ");
      double marks = Double.parseDouble(scanner.nextLine().trim());
      students.add(new Student(id, name, marks));
    }
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
      out.writeObject(students);
      System.out.println("Student saved to: "+ fileName);
    } catch (IOException e) {
      System.out.println("Serialization error: " + e.getMessage());
    }
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
      @SuppressWarnings("unchecked")
      List<Student> restored = (List<Student>) in.readObject();
      System.out.println("Deserialized students: ");
      for (Student s: restored) {
        System.out.println(s);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Deserialization error: " + e.getMessage());
    }
    scanner.close();
  }
}
