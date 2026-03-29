import java.util.*;
import java.io.*;


public class WriteFile {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter text into the file.");
    String input = sc.nextLine();
    try {
      FileWriter writer = new FileWriter("/home/virtualabishek/Desktop/bit-7th-sem/advance-java/preboard-prep/test.txt");
      writer.write(input);
      writer.close();
      System.out.println("The files written successfully.");
    } catch(IOException e) {
      System.out.println("The error occurs: " + e);
      e.printStackTrace();
    }
    sc.close();
  }
}
