# Quick Reference: RMI Execution Flow

## The 5 Files You Need (in Order of Understanding)

### 1. StudentRecord.java
```
Purpose: DATA CLASS
- Holds student information (id, name, email, marks)
- Must implement Serializable
- Can be sent over network
```

### 2. StudentInterface.java
```
Purpose: REMOTE INTERFACE (CONTRACT)
- Defines what methods are available remotely
- Extends Remote
- All methods throw RemoteException
- This is the "menu" of services
```

### 3. StudentRecordImpl.java
```
Purpose: IMPLEMENTATION (ACTUAL LOGIC)
- Implements StudentInterface
- Extends UnicastRemoteObject (makes it remote)
- Contains HashMap for storing data
- Lives on the SERVER
```

### 4. StudentServer.java
```
Purpose: SERVER STARTUP
- Creates the remote object
- Creates/gets RMI Registry
- Binds object to registry with name "StudentService"
- Keeps running to serve clients
```

### 5. StudentClient.java
```
Purpose: CLIENT ACCESS
- Connects to registry
- Looks up "StudentService"
- Calls remote methods
- Displays results
```

---

## Execution Sequence

```
┌─ Terminal 1: RMI Registry ─────────────────────────────────┐
│  $ rmiregistry 1099                                         │
│  (Running... listening on port 1099)                        │
└──────────────────────────────────────────────────────────────┘

┌─ Terminal 2: StudentServer ────────────────────────────────┐
│  $ java StudentServer                                       │
│  ✓ Remote object created                                    │
│  ✓ New RMI Registry on port 1099                           │
│  ✓ Service bound as 'StudentService'                        │
│  (Running... waiting for clients)                           │
└──────────────────────────────────────────────────────────────┘

┌─ Terminal 3: StudentClient ────────────────────────────────┐
│  $ java StudentClient                                       │
│  Connecting to RMI Registry...                              │
│  ✓ Connected to StudentService!                             │
│  Adding students...                                         │
│  ✓ Student added: Raj Kumar                                │
│  ✓ Student added: Priya Singh                              │
│  ✓ Student added: Amit Patel                               │
│  Total students: 3                                          │
│  (Operations complete)                                      │
└──────────────────────────────────────────────────────────────┘
```

---

## Network Communication Diagram

```
CLIENT SIDE                      NETWORK                    SERVER SIDE
===========                      =======                    ===========

Student client code              RMI Transport              StudentRecordImpl
        |
        |-- lookup("StudentService") ----[Serialized request]----> Registry lookup
        |                                                              |
        |<-- [Reference to remote object] -----------------------------|
        |
        |-- addStudent(record) ----------[Serialized parameters]-----> addStudent()
        |                                                              |
        |                          [Execute method on server]         |
        |                                                              |
        |<-- [Serialized result: true/false] --------------------------|
        |
        |-- getStudent(1) ---------------[Serialized parameters]-----> getStudent()
        |                                                              |
        |<-- [Serialized StudentRecord object] -----------------------|
        |
        |-- Display result to user

```

---

## Key Concepts

### synchronized Methods
```java
public synchronized boolean addStudent(StudentRecord record)
```
- Makes the method thread-safe
- Only one client can call it at a time
- Prevents data corruption when multiple clients access simultaneously

### RemoteException
```java
public boolean addStudent(StudentRecord record) throws RemoteException
```
- Must be thrown by all remote methods
- Network can fail anytime
- Client must handle this exception

### UnicastRemoteObject
```java
public class StudentRecordImpl extends UnicastRemoteObject
```
- Makes the object remotely accessible
- Handles network communication
- Provides remote object semantics

---

## Method Call Analogy

### Local Method Call
```java
StudentRecordImpl student = new StudentRecordImpl();
student.addStudent(record);  // Direct - same process
```

### Remote Method Call
```java
StudentInterface student = (StudentInterface) registry.lookup("StudentService");
student.addStudent(record);  // Over network - different process/machine
```

Both look the same in code, but RMI handles network transparently!

---

## Common Patterns

### Pattern 1: Create Server
```java
// Create implementation
StudentRecordImpl service = new StudentRecordImpl();

// Get registry
Registry registry = LocateRegistry.createRegistry(1099);

// Bind to registry
registry.rebind("StudentService", service);
```

### Pattern 2: Access Remote Service
```java
// Get registry
Registry registry = LocateRegistry.getRegistry("localhost", 1099);

// Lookup service
StudentInterface service = (StudentInterface) registry.lookup("StudentService");

// Call methods
service.addStudent(record);
```

### Pattern 3: Handle Errors
```java
try {
    // RMI operations
} catch (NotBoundException e) {
    // Service not found in registry
} catch (RemoteException e) {
    // Network error
}
```

---

## Compilation & Execution Checklist

- [ ] All .java files in same directory
- [ ] Compile: `javac *.java`
- [ ] Start RMI Registry: `rmiregistry 1099 &`
- [ ] Run Server: `java StudentServer`
- [ ] Run Client: `java StudentClient`
- [ ] Check output for errors
- [ ] Stop with Ctrl+C

---

## Remember:
1. **Server must run before client** - Registry needs to have the service
2. **Port 1099 is default RMI port** - Make sure it's not blocked
3. **All data must be Serializable** - To travel over network
4. **RemoteException always possible** - Network can fail anytime
5. **Look at StudentInterface for available methods** - That's the contract

Good Luck! 📚
