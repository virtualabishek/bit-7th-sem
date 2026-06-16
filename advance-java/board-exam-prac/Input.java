import java.util.Scanner;

class Input {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter integer.");
    int num = sc.nextInt();
    if(num < 0) {
      throw new Exception("Number is -ve.");
    }
  }
}
