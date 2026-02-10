import java.io.*;
public class File {
public static void main(String[] args) {
  try (FileWriter writer = new FileWriter("test.txt")) {
    writer.write("printStackTrace");
  } catch(IOException e) {
    e.printStackTrace();
  }
}
}
