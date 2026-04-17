import java.util.Scanner;

public class M1_UD03_Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** Bem Vindo ***");

        /*
         *  "String Build"
         *  para monitorizar o texto, analisa e converte para maiúsculas/minúsculas,
         *  e adiciona o texto já "formatado" (".append()")
         */
        StringBuilder textoFinal = new StringBuilder();

        System.out.print("Digite um texto: ");
        String texto = sc.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (caractere == '.') {
                break; // sai do loop ao primeiro ponto (.)
            }

            // Converte maiúscula para minúscula ou vice-versa
            if (Character.isLetter(caractere)) { // Verifica se é uma letra
                if (Character.isLowerCase(caractere)) { // Se for minúscula
                    textoFinal.append(Character.toUpperCase(caractere)); // Converte para maiúscula
                } else { // Se for maiúscula
                    textoFinal.append(Character.toLowerCase(caractere)); // Converte para minúscula
                }
            } else {
                textoFinal.append(caractere); // Mantém o caractere inalterado
            }
        }
        // Imprime resultado
        System.out.println("Conversão: " + textoFinal);

        sc.close();
    }
}