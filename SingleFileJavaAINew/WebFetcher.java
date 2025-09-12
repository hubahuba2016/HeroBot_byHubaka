import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WebFetcher {
    public static void main(String[] args) {
        String query = "what is artificial intelligence"; // you can change this
        String result = fetchFromWeb(query);
        System.out.println("Search result: " + result);
    }

    private static String fetchFromWeb(String query) {
        try {
            // Encode query for safe URL usage
            String urlStr = "https://api.duckduckgo.com/?q=" +
                    URLEncoder.encode(query, "UTF-8") +
                    "&format=json";

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            return response.toString(); // full JSON string
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
