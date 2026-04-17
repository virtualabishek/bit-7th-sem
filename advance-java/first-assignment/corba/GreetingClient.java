import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import GreetingModule.GreetingService;
import GreetingModule.GreetingServiceHelper;

/**
 * CORBA Client
 * Connects to server and calls remote greet method
 */
public class GreetingClient {
    
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);
            
            // Get naming context
            org.omg.CORBA.Object namingContextObj = 
                orb.resolve_initial_references("NameService");
            NamingContextExt namingContext = 
                NamingContextExtHelper.narrow(namingContextObj);
            
            // Resolve greeting service
            // String name = "GreetingService";
            // GreetingService greetingService = 
            //     GreetingServiceHelper.narrow(namingContext.resolve_str(name));
            
            // For testing: create IOR string manually or use hardcoded reference
            // String ior = args[0];  // IOR passed as argument
            // org.omg.CORBA.Object obj = orb.string_to_object(ior);
            // GreetingService greetingService = GreetingServiceHelper.narrow(obj);
            
            // Call remote method
            String result = greetingService.greet("Alice");
            System.out.println(result);
            
            orb.destroy();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
