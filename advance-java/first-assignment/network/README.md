# TCP Client-Server (Java)

## Question
Write a Java program for a TCP client-server application where:
- The server sends a message `Hello Client`
- The client receives and displays it

## Files
- `TCPServer.java`
- `TCPClient.java`

## How to Run

### 1. Compile
```bash
cd ~/Desktop/bit-7th-sem/advance-java/first-assignment/network
javac TCPServer.java TCPClient.java
```

### 2. Run Server (Terminal 1)
```bash
java TCPServer
```

### 3. Run Client (Terminal 2)
```bash
java TCPClient
```

## Expected Output

Server:
```text
Server started on port 5000
Message sent to client.
```

Client:
```text
Message from server: Hello Client
```
