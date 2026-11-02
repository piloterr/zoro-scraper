// Zoro Product API – Java example (Java 11+)
// Usage: PILOTERR_API_KEY=your-key java ProductExample.java
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ProductExample {
    static String enc(String v) {
        return URLEncoder.encode(v, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        String query = "query=" + enc("https://www.zoro.com/3m-safety-glasses-securefit-200-series-scotchgard-anti-fog-frameless-blue-temples-clear-lens-sf201sgaf-blu/i/G1937045/");

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.piloterr.com/v2/zoro/product?" + query))
            .header("x-api-key", System.getenv("PILOTERR_API_KEY"))
            .timeout(Duration.ofSeconds(60))
            .GET()
            .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
            .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.err.println("Piloterr error " + response.statusCode() + ": " + response.body());
            System.exit(1);
        }
        System.out.println(response.body());
    }
}
