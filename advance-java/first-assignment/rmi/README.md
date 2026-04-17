# RMI Calculator Program

## Question
Write a simple RMI program to implement a remote calculator that performs addition of two numbers. Show both server and client-side logic.

---

## Files Created

1. **CalculatorInterface.java** - Remote interface with add() method
2. **CalculatorImpl.java** - Server-side implementation
3. **CalculatorServer.java** - Server that creates registry and binds object
4. **CalculatorClient.java** - Client that calls remote method

---

## How to Run

### Terminal 1: Start RMI Registry
```bash
cd ~/Desktop/bit-7th-sem/advance-java/first-assignment/rmi
rmiregistry 1099
```
*(Keep this running)*

### Terminal 2: Start Server
```bash
cd ~/Desktop/bit-7th-sem/advance-java/first-assignment/rmi
javac CalculatorInterface.java
javac CalculatorImpl.java
javac CalculatorServer.java
java CalculatorServer
```

### Terminal 3: Run Client
```bash
cd ~/Desktop/bit-7th-sem/advance-java/first-assignment/rmi
javac CalculatorClient.java
java CalculatorClient
```

---

## Expected Output

**Server Output:**
```
Server started on port 1099
Calculator bound and ready
```

**Client Output:**
```
Result: 10 + 20 = 30
```

---

## Key Concepts

### Remote Interface
```java
public interface CalculatorInterface extends Remote {
    int add(int a, int b) throws RemoteException;
}
```

### Server Implementation
```java
public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
```

### Server Setup
```java
Registry registry = LocateRegistry.createRegistry(1099);
CalculatorImpl calculator = new CalculatorImpl();
registry.rebind("Calculator", calculator);
```

### Client Lookup
```java
Registry registry = LocateRegistry.getRegistry("localhost", 1099);
CalculatorInterface calculator = (CalculatorInterface) registry.lookup("Calculator");
int result = calculator.add(10, 20);
```

