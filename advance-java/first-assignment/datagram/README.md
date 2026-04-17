# UDP Datagram Client-Server (Java)

## Question
Write a Java program using DatagramSocket and DatagramPacket to send a message from client to server and display it.

## Files
- UDPServer.java
- UDPClient.java

## How to Run

1. Compile both files:
```bash
cd ~/Desktop/bit-7th-sem/advance-java/first-assignment/datagram
javac UDPServer.java UDPClient.java
```

2. Start server (Terminal 1):
```bash
java UDPServer
```

3. Start client (Terminal 2):
```bash
java UDPClient
```

## Expected Output

Server:
```text
UDP Server started on port 6000
Message from client: Hello Server
```

Client:
```text
Message sent to server: Hello Server
```
