import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

    static final String HOST = "localhost";
    static final int    PORT = 8000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter path of file to send: ");
        String filePath = sc.nextLine().trim();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }
        if (!file.isFile()) {
            System.out.println("That's a directory, not a file.");
            return;
        }

        System.out.println("Connecting to server " + HOST + ":" + PORT + "...");

        try (
            Socket socket = new Socket(HOST, PORT);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream  dis = new DataInputStream(socket.getInputStream());
            FileInputStream  fis = new FileInputStream(file)
        ) {
            System.out.println("Connected!");

            dos.writeUTF(file.getName());

            dos.writeLong(file.length());
            System.out.println("Sending: " + file.getName() + " (" + file.length() + " bytes)");
            byte[] buffer = new byte[4096];
            int    bytesRead;
            long   totalSent = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
                totalSent += bytesRead;
                int progress = (int) ((totalSent * 100) / file.length());
                System.out.print("\rProgress: " + progress + "% (" + totalSent + "/" + file.length() + " bytes)");
            }

            dos.flush(); 
            System.out.println("\nFile sent! Waiting for confirmation...");
            String response = dis.readUTF();
            System.out.println("Server says: " + response);
        }
    }
}