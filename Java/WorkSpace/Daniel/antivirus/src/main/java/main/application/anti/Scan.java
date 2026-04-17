package main.application.anti;

import main.application.utils.Logger;
import main.application.utils.HashUtil;

import java.io.File;
import java.util.Scanner;

public class Scan {
    public void runScan() {
        Scanner input = new Scanner(System.in);
        Logger.log("Início do scan...");

        System.out.println("\n🔍 Agora vamos verificar ficheiros locais.");
        System.out.print("📁 Introduz o caminho de um ficheiro ou pasta: ");
        String path = input.nextLine().trim();

        File root = new File(path);
        if (root.exists()) {
            verificarFicheirosRecursivamente(root);
        } else {
            System.out.println("❌ Caminho não encontrado.");
            Logger.log("Caminho não encontrado: " + path);
        }

        input.close();
        Logger.log("Scan concluído.\n");
        System.out.println("\n✅ Scan concluído!");
    }

    private void verificarFicheirosRecursivamente(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    verificarFicheirosRecursivamente(f);
                }
            }
        } else {
            String hash = HashUtil.calcularHash(file);
            System.out.println("Verificando ficheiro: " + file.getAbsolutePath());

            // Consulta à API do MalwareBazaar
            MalwareBazaarAPI api = new MalwareBazaarAPI();
            boolean isMalicious = api.consultarHash(hash);

            if (isMalicious) {
                System.out.println("💀 Ficheiro malicioso DETECTADO: " + file.getAbsolutePath());
                Logger.log("💀 Ficheiro malicioso detectado: " + file.getAbsolutePath());
            } else {
                System.out.println("✅ Ficheiro seguro: " + file.getAbsolutePath());
                Logger.log("✅ Ficheiro seguro: " + file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        Scan scan = new Scan();
        scan.runScan();
    }
}


// resultado.append("💀 Malware detectado!\n");
// resultado.append("🔖 Signature: ").append(malwareInfo.optString("signature", "N/A")).append("\n");
// resultado.append("🧬 File type: ").append(malwareInfo.optString("file_type", "N/A")).append("\n");
// resultado.append("📅 Primeira vez visto: ").append(malwareInfo.optString("first_seen", "N/A")).append("\n");
// resultado.append("🏷️ Tags: ").append(malwareInfo.optJSONArray("tags")).append("\n");
