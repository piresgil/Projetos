package main.application.phishing;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public class OpenPhish {

    public static void baixarPhishingFeed(String url, String destino) throws IOException {

        URL feedUrl = new URL(url);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(feedUrl.openStream()));
             BufferedWriter out = new BufferedWriter(new FileWriter(destino))) {

            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
        }
    }
    public static List<String> lerURLsPhishing(String caminhoFicheiro) throws IOException {
        return Files.readAllLines(new File(caminhoFicheiro).toPath());
    }

/*
    public static void main(String[] args) {
        String urlPhishFeed = "https://openphish.com/feed.txt";
        String caminhoPhishing = "C:\\Temp\\BDVirus\\openphish_feed.txt";

        try {
            baixarPhishingFeed(urlPhishFeed, caminhoPhishing);
            List<String> urlsPhishing = lerURLsPhishing(caminhoPhishing);
            System.out.println("🚨 URLs de phishing carregadas: " + urlsPhishing.size());

            Scanner scanner = new Scanner(System.in);
            System.out.print("🔎 Introduz o URL a verificar: ");
            String urlParaVerificar = scanner.nextLine().trim();

            // Verifica se o URL está na lista
            if (urlsPhishing.contains(urlParaVerificar)) {
                System.out.println("🚨 Este URL está na lista de phishing!");
            } else {
                System.out.println("✅ Este URL não está na lista.");
            }

        } catch (IOException e) {
            System.out.println("❌ Erro ao processar a lista de phishing: " + e.getMessage());
        }
    }
*/

    public static boolean pesquisarUrl(String urlParaVerificar) {
        String urlPhishFeed = "https://openphish.com/feed.txt";
        String caminhoPhishing = "C:\\Temp\\BDVirus\\openphish_feed.txt";

        try {
            baixarPhishingFeed(urlPhishFeed, caminhoPhishing);
            List<String> urlsPhishing = lerURLsPhishing(caminhoPhishing);
            System.out.println("🚨 URLs de phishing carregadas: " + urlsPhishing.size());

            // Verifica se o URL está na lista
            if (urlsPhishing.contains(urlParaVerificar)) {
                System.out.println("🚨 Este URL está na lista de phishing!");
                return true;
            } else {
                System.out.println("✅ Este URL não está na lista.");
            }

        } catch (IOException e) {
            System.out.println("❌ Erro ao processar a lista de phishing: " + e.getMessage());
        }
        return false;
    }
}
