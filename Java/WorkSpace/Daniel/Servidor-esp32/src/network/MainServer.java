package network;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.net.InetSocketAddress;

public class MainServer {

    public static String ultimoJsonEsp32 = "{Sart LOG}";

    // Estado global da bomba
    public static boolean bombaLigada = false;

    public static void iniciarServidor() throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Endpoint base
        server.createContext("/", (HttpExchange exchange) -> {
            String resposta = "Servidor Java ativo!";
            exchange.sendResponseHeaders(200, resposta.length());
            exchange.getResponseBody().write(resposta.getBytes());
            exchange.close();
        });

        // ESP32 envia JSON
        server.createContext("/esp32", (HttpExchange exchange) -> {
            if ("POST".equals(exchange.getRequestMethod())) {

                InputStream is = exchange.getRequestBody();
                String json = new String(is.readAllBytes());

                System.out.println("Recebido do ESP32: " + json);

                // Guardar o último JSON recebido
                ultimoJsonEsp32 = json;

                String resposta = "OK";
                exchange.sendResponseHeaders(200, resposta.length());
                exchange.getResponseBody().write(resposta.getBytes());
                exchange.close();
            }
        });
        // ultima Leitura do esp32 guardada em Json
        server.createContext("/esp32/last", (HttpExchange exchange) -> {

            String resposta = ultimoJsonEsp32;

            exchange.sendResponseHeaders(200, resposta.length());
            exchange.getResponseBody().write(resposta.getBytes());
            exchange.close();
        });


        // GET e POST do relé
        server.createContext("/relay", (HttpExchange exchange) -> {

            if ("GET".equals(exchange.getRequestMethod())) {

                String json = "{\"bomba\":" + (bombaLigada ? "true" : "false") + "}";
                exchange.sendResponseHeaders(200, json.length());
                exchange.getResponseBody().write(json.getBytes());
                exchange.close();
                return;
            }

            if ("POST".equals(exchange.getRequestMethod())) {

                String body = new String(exchange.getRequestBody().readAllBytes());
                System.out.println("Comando recebido da APP: " + body);

                bombaLigada = body.contains("true");

                String resposta = "OK";
                exchange.sendResponseHeaders(200, resposta.length());
                exchange.getResponseBody().write(resposta.getBytes());
                exchange.close();
            }
        });

        server.start();
        System.out.println("Servidor Java a correr na porta 8080");
    }
}
