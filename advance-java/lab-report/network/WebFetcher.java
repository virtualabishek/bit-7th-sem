
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebFetcher {

    public static void main(String[] args) throws IOException {
        String urlString = "https://backend.modelnepalschool.edu.np/api/public/notices";
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (compatible; JavaURLConnection/1.0)");
        connection.connect();
        connection.getHeaderFields().forEach((key, values) -> {
            if (key != null) {
                System.out.println(key + " : " + values);
            }
        });
        System.out.println("Page contents: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
