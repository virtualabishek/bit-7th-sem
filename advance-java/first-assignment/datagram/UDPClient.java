import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        String message = "Hello Server";
        String host = "localhost";
        int port = 6000;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            byte[] data = message.getBytes();
            InetAddress address = InetAddress.getByName(host);

            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            clientSocket.send(packet);

            System.out.println("Message sent to server: " + message);
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
