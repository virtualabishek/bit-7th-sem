import java.util.Scanner;
class Calculator {
    int a,b;
    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    int add() {
        return a + b;
    }
    int sub() {
      if(a>=b) {
        return a-b;
      } else {
        return b - a;
      }
    }
    int mul() {
      return a * b;
    }
    float div() {
      if(b!=0) {
      return a/b; 
      } 
      else {
        System.out.println("Division by 0 is not possible. Try, Another Number.");
        return 0;
      }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First number: ");
        int a = sc.nextInt();
        System.out.println("Enter second number: ");
        int b = sc.nextInt();
        System.out.println("Simple calculator");
        System.out.println("Instructions: ");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("Enter your choise..");
        int choice = sc.nextInt();
        Calculator cal = new Calculator(a,b);
        switch(choice) {
          case 1:
            System.out.println("Result: " + cal.add());
            break;
          case 2:
            System.out.println("Result: " + cal.sub());
            break;
          case 3:
            System.out.println("Result: " + cal.mul());
            break;
          case 4:
            System.out.println("Result: " + cal.div());
            break;
          default:
            System.out.println("Invalide choise. please see the instruction again");
        }

    }
}
