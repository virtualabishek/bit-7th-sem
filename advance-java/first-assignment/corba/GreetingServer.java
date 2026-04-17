import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import GreetingModule.GreetingServiceHelper;

/**
 * CORBA Server
 * Initializes ORB, creates servant, and publishes to naming service
 */
public class GreetingServer {
    
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);
            
            // Get root POA
            POA rootPOA = POAHelper.narrow(
                orb.resolve_initial_references("RootPOA"));
            
            // Create servant
            GreetingServiceImpl greetingImpl = new GreetingServiceImpl();
            
            // Register with POA
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(greetingImpl);
            GreetingModule.GreetingService greetingService = 
                GreetingServiceHelper.narrow(ref);
            
            // Activate POA
            rootPOA.the_POAManager().activate();
            
            // Publish to naming service (optional)
            // org.omg.CosNaming.NamingContextExt namingContext = ...
            // namingContext.rebind(name, greetingService);
            
            System.out.println("Greeting Server started");
            orb.run();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
