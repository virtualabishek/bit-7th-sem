
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {

    static final int PORT = 8000;
    static List<PrintWriter> clientWriters = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        System.out.println("Chat Server started on port: " + PORT);
        System.err.println("Waiting for clients...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        }
    }

    static void broadcast(String message, PrintWriter sender) {
        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;
        private PrintWriter out;
        private String clientName;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Enter your name: ");
                clientName = in.readLine();
                clientWriters.add(out);
                broadcast("[SERVER]" + clientName + "joined the chat!!!", out);
                System.out.println(clientName + "joined.");
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equals("/quit")) {
                        break;
                    }
                    System.out.println("[" + clientName + "]: " + message);
                    broadcast("[" + clientName + "]: " + message, out);
                }
            } catch (IOException e) {
                System.out.println(clientName + "disconnected with error" + e.getMessage());
            } finally {
                if (out != null) {
                    clientWriters.remove(out);
                }
                broadcast("[SERVER] " + clientName + " left the chat.", out);
                System.out.println(clientName + " left.");
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }

    }

}
