package network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    // Cliente HTTP reutilizável
    private static final HttpClient client = HttpClient.newHttpClient();

    // GET simples
    public static String get(String url) {
        try {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            return res.body();

        } catch (Exception e) {
            return "Erro GET: " + e.getMessage();
        }
    }

    // POST com JSON
    public static String post(String url, String json) {
        try {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            return res.body();

        } catch (Exception e) {
            return "Erro POST: " + e.getMessage();
        }
    }
}
