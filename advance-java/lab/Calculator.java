import java.util.Scanner;
public Calculator() {
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
    int div() {
      if(b!=0) {
      return a/b; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Simple Calculator");
        System.out.println("Instructions: ");
        System.out.println("1. Add \n 2. Sub \n 3. Mul \n 4.")
    }
}