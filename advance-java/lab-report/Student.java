import java.util.Scanner;
class Student {
    private String roll;
    private String name;
    public Student(String name, String roll) {
        this.name = name;
        this.roll = roll;
    }
    public String getRoll() {
        return roll;
    }
    public String getName() {
        return name;
    }
    public void displayInfo() {
        System.out.println("Hey! " + name + ". (Roll: " + roll + ")");
    }
}
class Result extends Student {
    private int marks;
    public Result(String name, String roll, int marks) {
        super(name, roll);
        this.marks = marks;
    }
    public String findGrade() {
        if (marks >= 90 && marks <= 100) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B+";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C+";
        } else if (marks >= 40) {
            return "C";
        } else if (marks >= 0) {
            return "Fail";
        } else {
            return "Invalid Marks";
        }
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("For your marks: " + marks + ", you got a: " + findGrade());
    }
}
public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll: ");
        String roll = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();
        Result student = new Result(name, roll, marks);
        student.displayInfo();
        scanner.close();
    }
}
