import java.util.Scanner;

public class M2_Ex4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // Entrada de dados
        //int x = 1;
        int x = (int) (Math.random() * 100 + 1);
        int tentativa = 0;      // Variavel para incrementação
        int totalTentativas = 7;        // Variavel para Loop/Condição

        System.out.println("*** Ben-vindo ***");
        System.out.println("*** Numero Secreto ***");
        System.out.println("Total de tentativas: " + totalTentativas);
        System.out.println("Digite um numero entre 1 a 100, para descobrir o Numero Secreto, ou 0 para Sair!");

        /*
         * Loop para tentativas, Enquanto o nº de tentativas for menor que 7
         * Verifica condicionais, e poderá Sair ou não do Programa
         */
        do {
            int resposta = sc.nextInt();     // Armazena resposta do user
            tentativa++;    // Incrementa Tentativa

            /*
             * Condicionais
             * Lê resposta do user
             * Responde e Sai do programa se atender as condições
             */
            if (resposta == 0) { // Sair
                System.out.println("---Sair---");
                System.exit(0);
            }
            if (resposta == x) { // Acertou
                System.out.println("*** Parabéns!!! ***");
                System.out.println("Acertou no Numero Secreto na " + tentativa + "ª Tentativa");
                System.exit(0);
            }
            if (resposta > x) {  // Valor acima
                System.out.println("Errou, Numero Secreto esta para baixo!");
            }
            if (resposta < x) {  // Valor abaixo
                System.out.println("Errou, Numero Secreto esta para cima!");
            }
        } while (tentativa < totalTentativas);

        System.out.println("*** Exedeu as tentativas ***");

        sc.close();     // Fecha Scanner, Entrada de dados
    }
}
