import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    static final String HOST = "localhost";
    static final int    PORT = 8000;

    public static void main(String[] args) throws IOException {
        System.out.println("Connecting to chat server at " + HOST + ":" + PORT);
        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println("Connected! Type /quit to exit.\n");
            BufferedReader serverIn = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverIn.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()) {
                String userInput = sc.nextLine();
                serverOut.println(userInput);

                if (userInput.equalsIgnoreCase("/quit")) {
                    System.out.println("Leaving chat...");
                    break;
                }
            }
        }
    }
}