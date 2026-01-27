import java.util.Scanner;
public class Test {
    int a, b;
    
    Test(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    int sum() {
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
        System.out.println("Hello World!");
        Test sd = new Test(2, 3);
        System.out.println("Sum: " + sd.sum());
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Test aq = new Test(a,b);
        System.out.println("Sum is: " + aq.sum());
        System.out.println("Sub is: " + aq.sub());
    }
}
