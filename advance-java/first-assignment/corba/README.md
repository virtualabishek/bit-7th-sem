# CORBA Greeting Service Program

## Question
Write a simple CORBA program (IDL + client-server outline) for a remote greeting service that returns a welcome message when a name is passed.

---

## ⚠️ Important Note

**CORBA tools (`idlj`, `orbd`) are NOT available by default on modern systems.**

This program demonstrates CORBA architecture and concepts. Modern Java no longer ships with full CORBA support. This is an **educational outline** showing:
- How CORBA IDL defines interfaces
- Server-side implementation structure
- Client-side connection logic
- Comparison with RMI (which is actively used)

---

## What is CORBA?

**CORBA** (Common Object Request Broker Architecture) is a distributed computing middleware that allows objects to communicate over a network, regardless of programming language or platform.

**Key Components:**
- **IDL**: Interface Definition Language - defines interface independent of implementation
- **ORB**: Object Request Broker - handles communication between client and server
- **POA**: Portable Object Adapter - manages servant objects on server
- **Naming Service**: Registry for discovering remote objects

---

## Files Created

1. **GreetingService.idl** - Interface definition (language-neutral)
2. **GreetingServiceImpl.java** - Server implementation of greeting service
3. **GreetingServer.java** - Server that initializes ORB and binds service
4. **GreetingClient.java** - Client that connects and calls remote method

---

## CORBA Architecture

### Step 1: IDL Definition
```idl
module GreetingModule {
    interface GreetingService {
        string greet(in string name);
    };
};
```
*This defines the remote interface independently of any programming language*

### Step 2: IDL Compilation (Would require idlj)
```bash
idlj -fall GreetingService.idl
```
*Generates Java stubs and skeletons*

### Step 3: Server Implementation
```java
public class GreetingServiceImpl extends GreetingServicePOA {
    public String greet(String name) {
        return "Welcome, " + name + "! Have a great day.";
    }
}
```

### Step 4: Server Initialization
```java
ORB orb = ORB.init(args, null);
POA rootPOA = POAHelper.narrow(
    orb.resolve_initial_references("RootPOA"));
GreetingServiceImpl greetingImpl = new GreetingServiceImpl();
org.omg.CORBA.Object ref = rootPOA.servant_to_reference(greetingImpl);
rootPOA.the_POAManager().activate();
orb.run();
```

### Step 5: Client Connection
```java
ORB orb = ORB.init(args, null);
// Look up service from naming service
GreetingService greetingService = 
    GreetingServiceHelper.narrow(namingContext.resolve_str("GreetingService"));
String result = greetingService.greet("Alice");
```

---

## How It Would Work (If Tools Were Available)

### Step 1: Setup
```bash
# Terminal 1: Start naming service
orbd -ORBInitialPort 1050

# Terminal 2: Compile IDL
idlj -fall GreetingService.idl

# Compile Java files
javac GreetingServiceImpl.java
javac GreetingServer.java
javac GreetingClient.java
```

### Step 2: Run
```bash
# Terminal 2: Start server
java GreetingServer -ORBInitialPort 1050 -ORBInitialHost localhost

# Terminal 3: Run client
java GreetingClient -ORBInitialPort 1050 -ORBInitialHost localhost
```

### Expected Output
```
Welcome, Alice! Have a great day.
```

---

## CORBA vs RMI vs Web Services

| Feature | CORBA | RMI | Web Services |
|---------|-------|-----|--------------|
| Language | Language-neutral (IDL) | Java only | Language-neutral |
| Standard | OMG standard | Java specific | W3C standard |
| Complexity | Higher | Lower | Medium |
| Modern Usage | Legacy systems | Still used | Most common today |
| Setup | Requires CORBA runtime | Built-in to Java | HTTP/REST |

---

## Code Structure

```
GreetingService.idl
├─ Defines greet(name) interface (language-neutral)
│
├─ Would be compiled by idlj to generate:
│  ├─ GreetingServicePOA.java (server skeleton)
│  └─ GreetingServiceHelper.java
│
GreetingServiceImpl.java
├─ Extends GreetingServicePOA
├─ Implements greet() method
│
GreetingServer.java
├─ Initializes ORB
├─ Creates servant (GreetingServiceImpl)
├─ Binds to naming service
├─ Listens for requests
│
GreetingClient.java
├─ Initializes ORB
├─ Looks up service from naming service
├─ Calls remote greet() method
└─ Displays result
```

---

## Key CORBA Concepts Explained

### 1. IDL (Interface Definition Language)
- Language-neutral specification of interfaces
- Used to generate stubs and skeletons
- Same IDL can be used with C++, Python, Java, etc.

### 2. ORB (Object Request Broker)
- Middleware layer for distributed communication
- Client makes local-looking calls → ORB handles networking
- Server receives calls through ORB

### 3. POA (Portable Object Adapter)
- Server-side component that manages servant objects
- Creates object references
- Routes incoming requests to servants

### 4. Naming Service
- Similar to RMI Registry
- Clients look up services by name
- Central registry of available remote objects

### 5. Stub & Skeleton
- **Stub**: Client-side proxy that looks like the real object
- **Skeleton**: Server-side dispatcher that routes calls to implementation

---

## Why CORBA Isn't Used Much Today

1. **Complexity**: Heavy setup with many components
2. **Learning curve**: Steeper than RMI or Web Services
3. **Alternatives**: RMI for Java, REST/JSON for web
4. **Modern preference**: Lightweight, language-agnostic solutions
5. **Maintenance**: Legacy systems still use it, but new projects avoid it

---

## Educational Value

This program demonstrates:
- ✅ How to define remote interfaces
- ✅ Client-server RPC architecture
- ✅ Middleware role in distributed systems
- ✅ Comparison with modern alternatives (RMI, Web Services)
- ✅ Object serialization and remote method invocation

---

## Files Location

All files are in: `first-assignment/corba/`

**Note:** This is a code structure and architectural reference. To actually run CORBA, you would need:
- Java with CORBA support
- IDL compiler (idlj)
- CORBA daemon (orbd)
- These are typically not included in modern Java distributions

For actual distributed computing needs, consider:
- **RMI** - Java-to-Java (simpler, shown in rmi/ folder)
- **REST/JSON** - Language-neutral web services (modern standard)
- **gRPC** - Efficient RPC framework (modern alternative)

