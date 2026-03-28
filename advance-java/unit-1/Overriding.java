import java.util.*;

class Overriding {
  int id;
  String name;
  float salary;
  void getData() {
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter the id, name and salary");
  id = sc.nextInt();
  name = sc.next();
  salary = sc.nextFloat();
  }

  void showData() {
    System.out.println("Id:" + id + "Name: " + name + "salary: " + salary);
  }
}


class Programmer extends Overriding {
  String Skills;
  void getData() {
    super.getData();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your tech skills");
    Skills = sc.next();
  }
  void showData() {
    super.showData();
    System.out.println("\n Your tech stacks are the: " + Skills);
  }
}


class Program {
  public static void main(String[] args) {
  Programmer p1 = new Programmer();
  p1.getData();
  System.out.println("--------------------------");
  p1.showData();
  }
}
