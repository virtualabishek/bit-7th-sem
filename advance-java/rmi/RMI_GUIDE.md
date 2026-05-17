# Remote Student Record System using RMI - Complete Guide

## What is RMI?
**RMI (Remote Method Invocation)** allows you to call methods on objects that exist on a different machine (or different process) over a network. It's like making a phone call to someone - you're communicating across distance.

## Key Concepts to Understand

### 1. Remote Interface
- A Java interface that defines the methods that can be called remotely
- Must extend `Remote` interface from `java.rmi`
- All methods must throw `RemoteException`
- This is like a "contract" - what methods are available for remote clients

### 2. Implementation Class
- Implements the Remote Interface
- Contains actual logic/functionality
- Must extend `UnicastRemoteObject` (handles network communication)
- This is the actual object that lives on the server

### 3. Server
- Creates an instance of the implementation class
- Binds it to the RMI Registry at a specific name
- RMI Registry is like a "phone directory" - it maps names to remote objects
- Default port: 1099

### 4. Client
- Looks up the remote object from the RMI Registry
- Calls methods on it like a local object
- Behind the scenes, RMI handles network communication

## How RMI Works (Simple Flow)

```
1. Server creates object and binds to Registry
   Server ----bind(name, object)----> RMI Registry (port 1099)

2. Client searches for object in Registry
   Client ----lookup(name)----> RMI Registry

3. Client gets reference and calls method
   Client ----method_call()----> Remote Object
   Remote Object returns result
   Client receives result
```

## Step-by-Step for Student Record System

### Step 1: Define Remote Interface
- Create `StudentInterface.java`
- List all methods you want to access remotely
- Methods: addStudent, getStudent, updateStudent, deleteStudent, etc.

### Step 2: Create Data Class
- Create `StudentRecord.java`
- This holds student data (name, id, marks, etc.)
- Must be Serializable (so it can be sent over network)

### Step 3: Implement the Interface
- Create `StudentRecordImpl.java`
- Implement all methods from interface
- Use HashMap/List to store students
- Extend UnicastRemoteObject

### Step 4: Create Server
- Create `StudentServer.java`
- Create RMI Registry (or use existing at port 1099)
- Create instance of implementation
- Bind it with a name like "StudentService"

### Step 5: Create Client
- Create `StudentClient.java`
- Get RMI Registry reference
- Look up "StudentService"
- Call remote methods
- Display results

## Important Points

1. **RemoteException**: Always thrown by remote methods - network can fail anytime
2. **Serialization**: Data sent over network must be serializable
3. **Port 1099**: Default RMI Registry port
4. **UnicastRemoteObject**: Base class for remote objects
5. **Registry**: The "phone book" that maps names to remote objects

## Running the Program

```bash
# Step 1: Start RMI Registry in background
rmiregistry 1099 &

# Step 2: Compile all files
javac *.java

# Step 3: Run server (keeps running)
java StudentServer

# Step 4: In another terminal, run client
java StudentClient
```

## Real-World Analogy

Think of it like ordering food from a restaurant:

- **Remote Interface** = Menu (what you can order)
- **Implementation** = Kitchen staff (who prepares the food)
- **Registry** = Restaurant listing in phone book
- **Client** = You calling the restaurant
- **Server** = The restaurant

You don't go to kitchen, you just call and request. The restaurant handles everything and sends the result back to you.
