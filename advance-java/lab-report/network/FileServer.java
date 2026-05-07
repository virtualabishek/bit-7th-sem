
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    static final int PORT = 8000;
    static final String SAVE_DIR = "receivedFile/";

    public static void main(String[] args) throws IOException {
        System.out.println("File transfer server started on" + PORT);
        System.out.println("file saved in: " + SAVE_DIR);
        try (ServerSocket ServerSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("\n Waiting for client...");
                Socket socket = ServerSocket.accept();
                System.out.println("client connected: " + socket.getInetAddress());
                new Thread(() -> handleTransfer(socket)).start();
            }
        }
    }

    static void handleTransfer(Socket socket) {
        try (
                DataInputStream dis = new DataInputStream(socket.getInputStream()); DataOutputStream dos = new DataOutputStream(socket.getOutputStream());) {
            String fileName = dis.readUTF();
            System.out.println("receiving file: " + fileName);
            long fileSize = dis.readLong();
            System.out.println("File size: " + fileSize + " bytes");
            File outputFile = new File(SAVE_DIR + fileName);
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                byte[] buffer = new byte[4096];
                long totalReceived = 0;
                int bytesRead;
                while (totalReceived < fileSize && (bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, fileSize - totalReceived))) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    totalReceived += bytesRead;
                    int progress = (int) ((totalReceived * 100) / fileSize);
                    System.out.print("\rProgress: " + progress + "% (" + totalReceived + "/" + fileSize + " bytes)");
                }
            }
            System.out.println("\nFile saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
