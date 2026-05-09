import java.util.Scanner;
import java.io.*;

public class FileOperation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the source of file: ");
    String source = scanner.nextLine().trim();
    System.out.println("Enter the destination of file to copy: ");
    String destination = scanner.nextLine().trim();
    int lineCount = 0;
    int wordCount = 0;
    int charCount = 0;
    try (BufferedReader reader = new BufferedReader (new FileReader(source));
         BufferedWriter writer = new BufferedWriter (new FileWriter(destination))) {
          String line;
          while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
            lineCount++;
            charCount = charCount + line.length();
            String trimmed = line.trim();
            if(!trimmed.isEmpty()) {
              String[] words = trimmed.split("\\s+");
              wordCount = wordCount + words.length;
            }
          }
          System.out.println("File copy successfully.");
          System.out.println("lines: " + lineCount);
          System.out.println("Words: " + wordCount);
          System.out.println("Characters: " + charCount );
        } catch(IOException e) {
          System.out.println("Error: "+ e.getMessage());
        } finally {
          scanner.close();
        }

  }
}
