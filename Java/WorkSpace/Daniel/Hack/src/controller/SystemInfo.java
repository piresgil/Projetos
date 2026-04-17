package controller;

import java.util.Map;

public class SystemInfo {
    // Nome do sistema operacional
    static String osName = System.getProperty("os.name");
    // Versão do sistema operacional
    static String osVersion = System.getProperty("os.version");
    // Arquitetura do sistema
    static String osArch = System.getProperty("os.arch");
    // Obtém todas as variáveis de ambiente
    static Map<String, String> env = System.getenv();
    // Obtém a instância do runtime
    static Runtime runtime = Runtime.getRuntime();

    // Memória total disponível para a JVM
    static long totalMemory = runtime.totalMemory();
    // Memória livre disponível
    static long freeMemory = runtime.freeMemory();
    // Memória máxima que a JVM pode usar
    static long maxMemory = runtime.maxMemory();


    public static void infoDataConsole() {
        // Exibe as informações
        System.out.print("Nome do SO: " + osName);
        System.out.print(", Versão do SO: " + osVersion);
        System.out.println(", Arquitetura do SO: " + osArch);
        // Exibe cada variável de ambiente
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Exibe as informações de memória
        System.out.println("Memória Total: " + totalMemory + " bytes");
        System.out.println("Memória Livre: " + freeMemory + " bytes");
        System.out.println("Memória Máxima: " + maxMemory + " bytes");
    }
}