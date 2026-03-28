/* Write a program to create Person class [3+7]
with variables id, and name. Include methods getPerson() and showPerson() in the
class. Again, create another class named Employee, which is child of person class.
Include member variable salary, and methods getEmployee(), and showEmployee()
in the class. Again, create a third class named Typist, which is child of Employee.
Include variable typespeed, and methods getTypist(), and showTypist() in the class.
Finally, create two objects of Typist class and read and display their details. */ 


// Person = QuestionOne in this cause i had to name according to file name in java.


class QuestionOne {
  private int id;
  private String name;
  public void getPerson(int id, String name) {
    this.id = id;
    this.name = name;
  }
  public void showPerson() {
    System.out.println("The ID is: " + id);
    System.out.println("The name is: " + name);
  }
}

class Employee extends QuestionOne {
  private double salary;
  public void getEmployee(int id, String name, double salary) {
    getPerson(id, name);
    this.salary = salary;
  }
  public void showEmployee() {
    showPerson();
    System.out.println("The salary is:" + salary);
  }
}


class Typist extends Employee {
  private int typespeed;
  public void getTypist(int id, String name, double salary, int typespeed) {
    getEmployee(id, name, salary);
    this.typespeed = typespeed;
  }

  public void showTypist() {
    showEmployee();
    System.out.println("The typespeed is: " + typespeed);
  }
}

class Program {
  public static void main(String[] args) {
    Typist t1 = new Typist();
    t1.getTypist(1, "Ram", 50000, 60);
    t1.showTypist();

    Typist t2 = new Typist();
    t2.getTypist(2, "Hari", 400000, 40);
    t2.showTypist();
  }
}

