
import java.util.Scanner;

class Cal {
    static void sum(int a, int b) {
        int add = a + b;
        System.out.println("Sum is: " + add);
    }
    static  void sub (int a, int b) {
        int subb = a -b;
        System.out.println("Sub is: "  + subb);
    }
    static int mul (int a, int b) {
        return  a * b;
    }
    public static void main(String[] args) {
        Scanner tk = new Scanner(System.in);
        System.out.println("Enter first number");
        int num1 = tk.nextInt();
        System.out.println("Enter second number");
        int num2 = tk.nextInt();
        // System.out.println(num1 + num2);
        sum(num1, num2);
        int myanswer = mul(num1, num2);
        System.out.println("ANswer is: " + myanswer);
        
    }
    
}
