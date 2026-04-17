import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message = in.readLine();
            System.out.println("Message from server: " + message);
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
